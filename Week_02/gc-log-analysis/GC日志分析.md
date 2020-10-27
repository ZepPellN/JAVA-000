### Week2 作业一

#### 通过分配大对象，分析各种GC日志

使用机器的基本信息：

```
Java HotSpot(TM) 64-Bit Server VM (25.261-b12) for bsd-amd64 JRE (1.8.0_261-b12), built on Jun 18 2020 06:38:55 by "java_re" with gcc 4.2.1 Compatible Apple LLVM 10.0.0 (clang-1000.11.45.5)
Memory: 4k page, physical 12582912k(2479692k free)
```



##### 1. 分析SerialGC日志

- $java -XX:+UseSerialGC -Xms512m -Xmx512m -XX:+PrintGCDetails GCLogAnalysis

结果分析：在1秒钟内共生成了9616个对象，触发了8次Young GC，7次Full GC。因触发GC导致用户线程STW总时间约为540ms，平均GC导致的STW时间约为54ms。

因日志过长，因此将截取第一次发生Young GC、第一次发生Full GC的日志进行分析。

- 第一次Young GC：使用的是单线程的STW垃圾收集器，标记复制算法。

```
[GC (Allocation Failure) 2020-10-26T20:19:47.897-0800: 0.165: [DefNew: 139776K->17472K(157248K), 0.0230622 secs] 139776K->44181K(506816K), 0.0231517 secs] [Times: user=0.02 sys=0.01, real=0.03 secs] 

可以看出，在这次垃圾收集之前，堆内存总的使用量为139776K,与年轻代使用量相同，因此可以推出GC之前老年代空间的使用量为0。GC之后年轻代的使用率约为11%，堆内存使用率约为9%。

GC前后对比，年轻代提升到老年代的对象占用了44181-17472=26708k的空间，GC使用的时间为30ms，属于延迟较高的范畴。
```

- 第一次Full GC：使用的是单线程的STW垃圾收集器，标记清除整理算法。

```
[GC (Allocation Failure) 2020-10-26T20:19:48.209-0800: 0.477: [DefNew: 157245K->157245K(157248K), 0.0000209 secs]2020-10-26T20:19:48.209-0800: 0.477: [Tenured: 299815K->271683K(349568K), 0.0482291 secs] 457060K->271683K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0483414 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 

可以看出，因为内存分配失败，先发生了一次YGC，这次YGC时间极短，且年轻代空间无任何变化，说明此次GC对年轻代无法再进行更多处理，需要触发FGC。
在FGC中，清理了28000k的老年代空间，GC之后老年代的使用率约为77.7%，数值较高，约有10%的下降，年轻代空间得到整理全部清空。内存整体使用率从90%下降至53%，个人认为在空间整理上仍然是一次比较有效的GC。从日志上表现为此次FGC后，再次发生GC时只发生了YGC。

此外，MetaSpace无明显变化，GC耗时约为50ms，约为YGC的两倍。此次GC后老年代存活对象约为270M，如果内存扩大十倍，GC后老年代内存使用量也扩大约10倍，耗时将达到500ms甚至更高，将带来非常明显的系统停顿。
```

- 执行结果

```
Heap
 def new generation   total 157248K, used 34721K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)
  eden space 139776K,  24% used [0x00000007a0000000, 0x00000007a21e87e0, 0x00000007a8880000)
  from space 17472K,   0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)
  to   space 17472K,   0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)
 tenured generation   total 349568K, used 349432K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)
 the space 349568K,  99% used [0x00000007aaaa0000, 0x00000007bffde1b0, 0x00000007bffde200, 0x00000007c0000000)
 Metaspace       used 2732K, capacity 4486K, committed 4864K, reserved 1056768K
 class space    used 296K, capacity 386K, committed 512K, reserved 1048576K

可以看到，老年代空间使用率几乎达到了100%，剩余的年轻代空间约为120MB。
```



##### 2. 分析Parallel GC日志

- $java -XX:+UseParallelGC -Xms512m -Xmx512m -XX:+PrintGCDetails GCLogAnalysis

结果分析：使用4个线程，在1秒钟内共生成了9701个对象，触发了20次Young GC，8次Full GC。因触发GC导致用户线程STW总时间约为440ms，平均GC导致的STW时间约为44ms。最后剩余的对空间约为130Mb。

可以看出，ParallelGC与SerialGC对象分配的速度相似，总的STW时间有缩短，平均STW时间也有缩短。

因日志过长，因此将截取第一次发生FullGC前的Young GC、第一次发生Full GC的日志进行分析。

- 第一次发生FullGC前的Young GC：使用的是并行的STW垃圾收集器ParNew，标记复制算法。

```
[GC (Allocation Failure) [PSYoungGen: 100258K->21714K(116736K)] 380429K->339554K(466432K), 0.0121481 secs] [Times: user=0.02 sys=0.02, real=0.01 secs] 

GC后年轻代的使用率约为18%，整个堆内存的使用率为73%，这个使用比例进入了一个不算低的范围。
此时的使用时间，real= (user + sys) / 4(默认线程数)，可以看出并行gc相比于串行gc缩短了stw的时间，性能有较大提升。

在GC之前，老年代的使用量为280171K；GC结束之后，年轻代使用量减少了78544K，总的堆内存使用量减少了40875K，那么可以推算出有37669K的对象从年轻代提升到老年代。
老年代的使用量为317840K，老年代的大小为349696K，老年代的使用率约为91%，可以看出老年代已经快满了，紧接着触发了下面的Full GC。
```

- 第一次发生FullGC：并行STW垃圾收集器ParOldGen，使用标记-清除-整理算法。

```
[Full GC (Ergonomics) [PSYoungGen: 21714K->0K(116736K)] [ParOldGen: 317839K->245866K(349696K)] 339554K->245866K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0357045 secs] [Times: user=0.13 sys=0.01, real=0.03 secs] 

首先进行了YGC，年轻代空间得到完全回收，在ParallelGC中Full GC年轻代的结果基本都是如此。
后进行了FGC，GC之前老年代使用率为91%，GC之后老年代使用率约为70%，有明显的下降。
FGC之前堆内存的使用率约为73%，FGC之后堆内存的使用率约为52%，也有明显的下降。
此外，Metaspace没有回收任何对象。GC持续的时间仍然在多线程环境下得到缩短，串行gc可能需要140ms停顿，在并行gc中只需要约30ms。
```

- 最终内存结果

```
Heap
 PSYoungGen      total 116736K, used 2561K [0x00000007b5580000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 58880K, 4% used [0x00000007b5580000,0x00000007b5800438,0x00000007b8f00000)
  from space 57856K, 0% used [0x00000007bc780000,0x00000007bc780000,0x00000007c0000000)
  to   space 57856K, 0% used [0x00000007b8f00000,0x00000007b8f00000,0x00000007bc780000)
 ParOldGen       total 349696K, used 331752K [0x00000007a0000000, 0x00000007b5580000, 0x00000007b5580000)
  object space 349696K, 94% used [0x00000007a0000000,0x00000007b43fa298,0x00000007b5580000)
 Metaspace       used 2732K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 296K, capacity 386K, committed 512K, reserved 1048576K

可以看出，与串行gc类似，老年代空间使用率仍然超过了90%，年轻代则仍然只有4%，剩余内存约为130MB。
```



##### 3. 分析CMS GC

- $ java -XX:+UseConcMarkSweepGC -XX:ConcGCThreads=4 -XX:MaxGCPauseMillis=50 -Xms512m -Xmx512m -XX:+PrintGCDetails GCLogAnalysis

结果分析：CMS并发线程数为4，



```
CommandLine flags: -XX:InitialHeapSize=536870912 -XX:MaxHeapSize=536870912 -XX:MaxNewSize=178958336 -XX:MaxTenuringThreshold=6 -XX:NewSize=178958336 -XX:OldPLABSize=16 -XX:OldSize=357912576 -XX:+PrintGC -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseConcMarkSweepGC -XX:+UseParNewGC 
2020-10-26T20:17:20.833-0800: 0.163: [GC (Allocation Failure) 2020-10-26T20:17:20.833-0800: 0.163: [ParNew: 139776K->17470K(157248K), 0.0127571 secs] 139776K->46203K(506816K), 0.0128873 secs] [Times: user=0.02 sys=0.03, real=0.01 secs] 
2020-10-26T20:17:20.864-0800: 0.195: [GC (Allocation Failure) 2020-10-26T20:17:20.864-0800: 0.195: [ParNew: 157246K->17472K(157248K), 0.0144001 secs] 185979K->86468K(506816K), 0.0144903 secs] [Times: user=0.02 sys=0.03, real=0.01 secs] 
2020-10-26T20:17:20.896-0800: 0.227: [GC (Allocation Failure) 2020-10-26T20:17:20.896-0800: 0.227: [ParNew: 157248K->17472K(157248K), 0.0212748 secs] 226244K->127004K(506816K), 0.0213988 secs] [Times: user=0.07 sys=0.01, real=0.02 secs] 
2020-10-26T20:17:20.936-0800: 0.266: [GC (Allocation Failure) 2020-10-26T20:17:20.936-0800: 0.266: [ParNew: 157248K->17472K(157248K), 0.0198743 secs] 266780K->163097K(506816K), 0.0199656 secs] [Times: user=0.07 sys=0.00, real=0.02 secs] 
2020-10-26T20:17:20.974-0800: 0.304: [GC (Allocation Failure) 2020-10-26T20:17:20.974-0800: 0.304: [ParNew: 157248K->17470K(157248K), 0.0229117 secs] 302873K->208300K(506816K), 0.0230029 secs] [Times: user=0.08 sys=0.02, real=0.02 secs] 
2020-10-26T20:17:20.997-0800: 0.327: [GC (CMS Initial Mark) [1 CMS-initial-mark: 190829K(349568K)] 211930K(506816K), 0.0002364 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:20.998-0800: 0.328: [CMS-concurrent-mark-start]
2020-10-26T20:17:21.002-0800: 0.332: [CMS-concurrent-mark: 0.004/0.004 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2020-10-26T20:17:21.002-0800: 0.332: [CMS-concurrent-preclean-start]
2020-10-26T20:17:21.002-0800: 0.332: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.002-0800: 0.332: [CMS-concurrent-abortable-preclean-start]
2020-10-26T20:17:21.016-0800: 0.346: [GC (Allocation Failure) 2020-10-26T20:17:21.016-0800: 0.346: [ParNew: 157246K->17472K(157248K), 0.0222667 secs] 348076K->250901K(506816K), 0.0224150 secs] [Times: user=0.08 sys=0.01, real=0.02 secs] 
2020-10-26T20:17:21.056-0800: 0.386: [GC (Allocation Failure) 2020-10-26T20:17:21.056-0800: 0.386: [ParNew: 157248K->17463K(157248K), 0.0222522 secs] 390677K->293098K(506816K), 0.0223553 secs] [Times: user=0.07 sys=0.01, real=0.02 secs] 
2020-10-26T20:17:21.096-0800: 0.426: [GC (Allocation Failure) 2020-10-26T20:17:21.096-0800: 0.426: [ParNew: 157239K->17471K(157248K), 0.0217172 secs] 432874K->332958K(506816K), 0.0218165 secs] [Times: user=0.08 sys=0.01, real=0.02 secs] 
2020-10-26T20:17:21.135-0800: 0.465: [GC (Allocation Failure) 2020-10-26T20:17:21.135-0800: 0.465: [ParNew: 157247K->157247K(157248K), 0.0000210 secs]2020-10-26T20:17:21.135-0800: 0.465: [CMS2020-10-26T20:17:21.135-0800: 0.465: [CMS-concurrent-abortable-preclean: 0.004/0.133 secs] [Times: user=0.30 sys=0.03, real=0.13 secs] 
 (concurrent mode failure): 315487K->253054K(349568K), 0.0488616 secs] 472734K->253054K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0489978 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
2020-10-26T20:17:21.201-0800: 0.531: [GC (Allocation Failure) 2020-10-26T20:17:21.201-0800: 0.531: [ParNew: 139776K->17471K(157248K), 0.0074172 secs] 392830K->299111K(506816K), 0.0075237 secs] [Times: user=0.03 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.209-0800: 0.539: [GC (CMS Initial Mark) [1 CMS-initial-mark: 281640K(349568K)] 302300K(506816K), 0.0001532 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.209-0800: 0.539: [CMS-concurrent-mark-start]
2020-10-26T20:17:21.211-0800: 0.541: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2020-10-26T20:17:21.211-0800: 0.541: [CMS-concurrent-preclean-start]
2020-10-26T20:17:21.212-0800: 0.542: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.212-0800: 0.542: [CMS-concurrent-abortable-preclean-start]
2020-10-26T20:17:21.227-0800: 0.557: [GC (Allocation Failure) 2020-10-26T20:17:21.227-0800: 0.557: [ParNew: 157247K->17471K(157248K), 0.0117681 secs] 438887K->341620K(506816K), 0.0118471 secs] [Times: user=0.05 sys=0.00, real=0.01 secs] 
2020-10-26T20:17:21.239-0800: 0.570: [CMS-concurrent-abortable-preclean: 0.001/0.028 secs] [Times: user=0.07 sys=0.00, real=0.02 secs] 
2020-10-26T20:17:21.239-0800: 0.570: [GC (CMS Final Remark) [YG occupancy: 26983 K (157248 K)]2020-10-26T20:17:21.239-0800: 0.570: [Rescan (parallel) , 0.0002386 secs]2020-10-26T20:17:21.240-0800: 0.570: [weak refs processing, 0.0000117 secs]2020-10-26T20:17:21.240-0800: 0.570: [class unloading, 0.0001974 secs]2020-10-26T20:17:21.240-0800: 0.570: [scrub symbol table, 0.0002785 secs]2020-10-26T20:17:21.240-0800: 0.571: [scrub string table, 0.0001330 secs][1 CMS-remark: 324149K(349568K)] 351132K(506816K), 0.0009137 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2020-10-26T20:17:21.240-0800: 0.571: [CMS-concurrent-sweep-start]
2020-10-26T20:17:21.241-0800: 0.571: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.241-0800: 0.571: [CMS-concurrent-reset-start]
2020-10-26T20:17:21.241-0800: 0.572: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.258-0800: 0.588: [GC (Allocation Failure) 2020-10-26T20:17:21.258-0800: 0.588: [ParNew: 157234K->17470K(157248K), 0.0138635 secs] 446134K->352949K(506816K), 0.0139460 secs] [Times: user=0.05 sys=0.00, real=0.02 secs] 
2020-10-26T20:17:21.272-0800: 0.602: [GC (CMS Initial Mark) [1 CMS-initial-mark: 335479K(349568K)] 355919K(506816K), 0.0001608 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.272-0800: 0.602: [CMS-concurrent-mark-start]
2020-10-26T20:17:21.274-0800: 0.604: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.274-0800: 0.604: [CMS-concurrent-preclean-start]
2020-10-26T20:17:21.275-0800: 0.605: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.275-0800: 0.605: [CMS-concurrent-abortable-preclean-start]
2020-10-26T20:17:21.275-0800: 0.605: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.275-0800: 0.605: [GC (CMS Final Remark) [YG occupancy: 45718 K (157248 K)]2020-10-26T20:17:21.275-0800: 0.605: [Rescan (parallel) , 0.0002463 secs]2020-10-26T20:17:21.275-0800: 0.605: [weak refs processing, 0.0000116 secs]2020-10-26T20:17:21.275-0800: 0.605: [class unloading, 0.0001960 secs]2020-10-26T20:17:21.275-0800: 0.606: [scrub symbol table, 0.0002724 secs]2020-10-26T20:17:21.276-0800: 0.606: [scrub string table, 0.0001329 secs][1 CMS-remark: 335479K(349568K)] 381197K(506816K), 0.0009146 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.276-0800: 0.606: [CMS-concurrent-sweep-start]
2020-10-26T20:17:21.276-0800: 0.607: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.276-0800: 0.607: [CMS-concurrent-reset-start]
2020-10-26T20:17:21.277-0800: 0.607: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.291-0800: 0.621: [GC (Allocation Failure) 2020-10-26T20:17:21.291-0800: 0.621: [ParNew: 157246K->17467K(157248K), 0.0106213 secs] 437419K->339860K(506816K), 0.0106940 secs] [Times: user=0.04 sys=0.01, real=0.01 secs] 
2020-10-26T20:17:21.302-0800: 0.632: [GC (CMS Initial Mark) [1 CMS-initial-mark: 322392K(349568K)] 343188K(506816K), 0.0001442 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.302-0800: 0.632: [CMS-concurrent-mark-start]
2020-10-26T20:17:21.304-0800: 0.634: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.304-0800: 0.634: [CMS-concurrent-preclean-start]
2020-10-26T20:17:21.305-0800: 0.635: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.305-0800: 0.635: [CMS-concurrent-abortable-preclean-start]
2020-10-26T20:17:21.305-0800: 0.635: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.305-0800: 0.635: [GC (CMS Final Remark) [YG occupancy: 40937 K (157248 K)]2020-10-26T20:17:21.305-0800: 0.635: [Rescan (parallel) , 0.0002486 secs]2020-10-26T20:17:21.305-0800: 0.635: [weak refs processing, 0.0000088 secs]2020-10-26T20:17:21.305-0800: 0.635: [class unloading, 0.0001943 secs]2020-10-26T20:17:21.305-0800: 0.636: [scrub symbol table, 0.0002683 secs]2020-10-26T20:17:21.306-0800: 0.636: [scrub string table, 0.0001335 secs][1 CMS-remark: 322392K(349568K)] 363330K(506816K), 0.0009088 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.306-0800: 0.636: [CMS-concurrent-sweep-start]
2020-10-26T20:17:21.306-0800: 0.637: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.306-0800: 0.637: [CMS-concurrent-reset-start]
2020-10-26T20:17:21.307-0800: 0.637: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.320-0800: 0.651: [GC (Allocation Failure) 2020-10-26T20:17:21.320-0800: 0.651: [ParNew: 157243K->17471K(157248K), 0.0120450 secs] 447800K->356726K(506816K), 0.0121309 secs] [Times: user=0.05 sys=0.00, real=0.01 secs] 
2020-10-26T20:17:21.333-0800: 0.663: [GC (CMS Initial Mark) [1 CMS-initial-mark: 339254K(349568K)] 357014K(506816K), 0.0001553 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.333-0800: 0.663: [CMS-concurrent-mark-start]
2020-10-26T20:17:21.335-0800: 0.665: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.335-0800: 0.665: [CMS-concurrent-preclean-start]
2020-10-26T20:17:21.335-0800: 0.666: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.335-0800: 0.666: [CMS-concurrent-abortable-preclean-start]
2020-10-26T20:17:21.335-0800: 0.666: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.336-0800: 0.666: [GC (CMS Final Remark) [YG occupancy: 41420 K (157248 K)]2020-10-26T20:17:21.336-0800: 0.666: [Rescan (parallel) , 0.0002554 secs]2020-10-26T20:17:21.336-0800: 0.666: [weak refs processing, 0.0000117 secs]2020-10-26T20:17:21.336-0800: 0.666: [class unloading, 0.0001967 secs]2020-10-26T20:17:21.336-0800: 0.666: [scrub symbol table, 0.0002755 secs]2020-10-26T20:17:21.336-0800: 0.667: [scrub string table, 0.0001324 secs][1 CMS-remark: 339254K(349568K)] 380675K(506816K), 0.0009292 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.337-0800: 0.667: [CMS-concurrent-sweep-start]
2020-10-26T20:17:21.338-0800: 0.668: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.338-0800: 0.668: [CMS-concurrent-reset-start]
2020-10-26T20:17:21.338-0800: 0.668: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.353-0800: 0.683: [GC (Allocation Failure) 2020-10-26T20:17:21.353-0800: 0.683: [ParNew: 157247K->157247K(157248K), 0.0000165 secs]2020-10-26T20:17:21.353-0800: 0.683: [CMS: 302579K->319566K(349568K), 0.0463144 secs] 459827K->319566K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0464182 secs] [Times: user=0.05 sys=0.00, real=0.04 secs] 
2020-10-26T20:17:21.399-0800: 0.730: [GC (CMS Initial Mark) [1 CMS-initial-mark: 319566K(349568K)] 320294K(506816K), 0.0001579 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2020-10-26T20:17:21.400-0800: 0.730: [CMS-concurrent-mark-start]
2020-10-26T20:17:21.402-0800: 0.732: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.402-0800: 0.732: [CMS-concurrent-preclean-start]
2020-10-26T20:17:21.402-0800: 0.732: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.402-0800: 0.732: [CMS-concurrent-abortable-preclean-start]
2020-10-26T20:17:21.417-0800: 0.747: [GC (Allocation Failure) 2020-10-26T20:17:21.417-0800: 0.747: [ParNew: 139776K->139776K(157248K), 0.0000172 secs]2020-10-26T20:17:21.417-0800: 0.747: [CMS2020-10-26T20:17:21.417-0800: 0.747: [CMS-concurrent-abortable-preclean: 0.000/0.015 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 
 (concurrent mode failure): 319566K->324377K(349568K), 0.0456285 secs] 459342K->324377K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0457360 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
2020-10-26T20:17:21.480-0800: 0.810: [GC (Allocation Failure) 2020-10-26T20:17:21.480-0800: 0.810: [ParNew (promotion failed): 139071K->156542K(157248K), 0.0084078 secs]2020-10-26T20:17:21.489-0800: 0.819: [CMS: 348803K->328428K(349568K), 0.0472363 secs] 463449K->328428K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0557605 secs] [Times: user=0.08 sys=0.00, real=0.05 secs] 
2020-10-26T20:17:21.536-0800: 0.866: [GC (CMS Initial Mark) [1 CMS-initial-mark: 328428K(349568K)] 329170K(506816K), 0.0001566 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.536-0800: 0.867: [CMS-concurrent-mark-start]
2020-10-26T20:17:21.538-0800: 0.869: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.539-0800: 0.869: [CMS-concurrent-preclean-start]
2020-10-26T20:17:21.539-0800: 0.869: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.539-0800: 0.869: [CMS-concurrent-abortable-preclean-start]
2020-10-26T20:17:21.539-0800: 0.869: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.539-0800: 0.869: [GC (CMS Final Remark) [YG occupancy: 23909 K (157248 K)]2020-10-26T20:17:21.539-0800: 0.870: [Rescan (parallel) , 0.0002940 secs]2020-10-26T20:17:21.540-0800: 0.870: [weak refs processing, 0.0000119 secs]2020-10-26T20:17:21.540-0800: 0.870: [class unloading, 0.0001937 secs]2020-10-26T20:17:21.540-0800: 0.870: [scrub symbol table, 0.0002710 secs]2020-10-26T20:17:21.540-0800: 0.870: [scrub string table, 0.0001296 secs][1 CMS-remark: 328428K(349568K)] 352338K(506816K), 0.0009739 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2020-10-26T20:17:21.540-0800: 0.871: [CMS-concurrent-sweep-start]
2020-10-26T20:17:21.541-0800: 0.871: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.541-0800: 0.871: [CMS-concurrent-reset-start]
2020-10-26T20:17:21.541-0800: 0.871: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.554-0800: 0.885: [GC (Allocation Failure) 2020-10-26T20:17:21.554-0800: 0.885: [ParNew: 139776K->139776K(157248K), 0.0000175 secs]2020-10-26T20:17:21.554-0800: 0.885: [CMS: 328382K->336400K(349568K), 0.0485093 secs] 468158K->336400K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0486408 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
2020-10-26T20:17:21.603-0800: 0.933: [GC (CMS Initial Mark) [1 CMS-initial-mark: 336400K(349568K)] 339231K(506816K), 0.0001044 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.603-0800: 0.934: [CMS-concurrent-mark-start]
2020-10-26T20:17:21.605-0800: 0.936: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.605-0800: 0.936: [CMS-concurrent-preclean-start]
2020-10-26T20:17:21.606-0800: 0.936: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.606-0800: 0.936: [CMS-concurrent-abortable-preclean-start]
2020-10-26T20:17:21.606-0800: 0.936: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.606-0800: 0.936: [GC (CMS Final Remark) [YG occupancy: 20608 K (157248 K)]2020-10-26T20:17:21.606-0800: 0.936: [Rescan (parallel) , 0.0002861 secs]2020-10-26T20:17:21.607-0800: 0.937: [weak refs processing, 0.0000089 secs]2020-10-26T20:17:21.607-0800: 0.937: [class unloading, 0.0001956 secs]2020-10-26T20:17:21.607-0800: 0.937: [scrub symbol table, 0.0002730 secs]2020-10-26T20:17:21.607-0800: 0.937: [scrub string table, 0.0001304 secs][1 CMS-remark: 336400K(349568K)] 357008K(506816K), 0.0009473 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.607-0800: 0.938: [CMS-concurrent-sweep-start]
2020-10-26T20:17:21.608-0800: 0.938: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.608-0800: 0.938: [CMS-concurrent-reset-start]
2020-10-26T20:17:21.608-0800: 0.938: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.621-0800: 0.951: [GC (Allocation Failure) 2020-10-26T20:17:21.621-0800: 0.951: [ParNew: 139228K->139228K(157248K), 0.0000176 secs]2020-10-26T20:17:21.621-0800: 0.951: [CMS: 336391K->344500K(349568K), 0.0497657 secs] 475619K->344500K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0498734 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
2020-10-26T20:17:21.671-0800: 1.001: [GC (CMS Initial Mark) [1 CMS-initial-mark: 344500K(349568K)] 345258K(506816K), 0.0002118 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.671-0800: 1.002: [CMS-concurrent-mark-start]
2020-10-26T20:17:21.674-0800: 1.004: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.674-0800: 1.004: [CMS-concurrent-preclean-start]
2020-10-26T20:17:21.674-0800: 1.004: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.674-0800: 1.004: [CMS-concurrent-abortable-preclean-start]
2020-10-26T20:17:21.674-0800: 1.004: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.674-0800: 1.005: [GC (CMS Final Remark) [YG occupancy: 27767 K (157248 K)]2020-10-26T20:17:21.674-0800: 1.005: [Rescan (parallel) , 0.0002561 secs]2020-10-26T20:17:21.675-0800: 1.005: [weak refs processing, 0.0000120 secs]2020-10-26T20:17:21.675-0800: 1.005: [class unloading, 0.0001968 secs]2020-10-26T20:17:21.675-0800: 1.005: [scrub symbol table, 0.0002739 secs]2020-10-26T20:17:21.675-0800: 1.005: [scrub string table, 0.0001335 secs][1 CMS-remark: 344500K(349568K)] 372268K(506816K), 0.0009300 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.675-0800: 1.006: [CMS-concurrent-sweep-start]
2020-10-26T20:17:21.676-0800: 1.006: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.676-0800: 1.006: [CMS-concurrent-reset-start]
2020-10-26T20:17:21.676-0800: 1.006: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.690-0800: 1.020: [GC (Allocation Failure) 2020-10-26T20:17:21.690-0800: 1.020: [ParNew: 139776K->139776K(157248K), 0.0000193 secs]2020-10-26T20:17:21.690-0800: 1.020: [CMS: 344428K->345770K(349568K), 0.0509724 secs] 484204K->345770K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0511044 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
2020-10-26T20:17:21.741-0800: 1.071: [GC (CMS Initial Mark) [1 CMS-initial-mark: 345770K(349568K)] 348622K(506816K), 0.0001403 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.741-0800: 1.072: [CMS-concurrent-mark-start]
2020-10-26T20:17:21.743-0800: 1.074: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.743-0800: 1.074: [CMS-concurrent-preclean-start]
2020-10-26T20:17:21.744-0800: 1.074: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.744-0800: 1.074: [CMS-concurrent-abortable-preclean-start]
2020-10-26T20:17:21.744-0800: 1.074: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.744-0800: 1.074: [GC (CMS Final Remark) [YG occupancy: 25623 K (157248 K)]2020-10-26T20:17:21.744-0800: 1.074: [Rescan (parallel) , 0.0002445 secs]2020-10-26T20:17:21.744-0800: 1.075: [weak refs processing, 0.0000119 secs]2020-10-26T20:17:21.744-0800: 1.075: [class unloading, 0.0001955 secs]2020-10-26T20:17:21.745-0800: 1.075: [scrub symbol table, 0.0002740 secs]2020-10-26T20:17:21.745-0800: 1.075: [scrub string table, 0.0001337 secs][1 CMS-remark: 345770K(349568K)] 371394K(506816K), 0.0009160 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.745-0800: 1.075: [CMS-concurrent-sweep-start]
2020-10-26T20:17:21.746-0800: 1.076: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-26T20:17:21.746-0800: 1.076: [CMS-concurrent-reset-start]
2020-10-26T20:17:21.746-0800: 1.076: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 par new generation   total 157248K, used 70388K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)
  eden space 139776K,  50% used [0x00000007a0000000, 0x00000007a44bd0c0, 0x00000007a8880000)
  from space 17472K,   0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)
  to   space 17472K,   0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)
 concurrent mark-sweep generation total 349568K, used 345517K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace       used 2732K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 296K, capacity 386K, committed 512K, reserved 1048576K

```



##### 4. 分析G1 GC

- 

