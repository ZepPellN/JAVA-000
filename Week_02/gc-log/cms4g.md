simu@simudeiMac src % java -XX:+UseConcMarkSweepGC -Xms4g -Xmx4g -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

正在执行....

2020-10-26T20:09:44.251-0800: [GC (Allocation Failure) 2020-10-26T20:09:44.251-0800: [ParNew: 272640K->34048K(306688K), 0.0289868 secs] 272640K->84329K(4160256K), 0.0290340 secs] [Times: user=0.07 sys=0.05, real=0.03 secs] 

2020-10-26T20:09:44.329-0800: [GC (Allocation Failure) 2020-10-26T20:09:44.329-0800: [ParNew: 306688K->34046K(306688K), 0.0346931 secs] 356969K->164359K(4160256K), 0.0347332 secs] [Times: user=0.08 sys=0.06, real=0.04 secs] 

2020-10-26T20:09:44.405-0800: [GC (Allocation Failure) 2020-10-26T20:09:44.405-0800: [ParNew: 306596K->34048K(306688K), 0.0488536 secs] 436909K->243227K(4160256K), 0.0488897 secs] [Times: user=0.17 sys=0.02, real=0.05 secs] 

2020-10-26T20:09:44.492-0800: [GC (Allocation Failure) 2020-10-26T20:09:44.492-0800: [ParNew: 306688K->34048K(306688K), 0.0490058 secs] 515867K->322261K(4160256K), 0.0490482 secs] [Times: user=0.17 sys=0.02, real=0.05 secs] 

2020-10-26T20:09:44.578-0800: [GC (Allocation Failure) 2020-10-26T20:09:44.578-0800: [ParNew: 306688K->34048K(306688K), 0.0507205 secs] 594901K->403972K(4160256K), 0.0507689 secs] [Times: user=0.17 sys=0.02, real=0.05 secs] 

2020-10-26T20:09:44.667-0800: [GC (Allocation Failure) 2020-10-26T20:09:44.667-0800: [ParNew: 306688K->34043K(306688K), 0.0467627 secs] 676612K->476287K(4160256K), 0.0467999 secs] [Times: user=0.15 sys=0.02, real=0.05 secs] 

2020-10-26T20:09:44.749-0800: [GC (Allocation Failure) 2020-10-26T20:09:44.749-0800: [ParNew: 306683K->34046K(306688K), 0.0530339 secs] 748927K->559942K(4160256K), 0.0530722 secs] [Times: user=0.18 sys=0.03, real=0.06 secs] 

2020-10-26T20:09:44.840-0800: [GC (Allocation Failure) 2020-10-26T20:09:44.840-0800: [ParNew: 306686K->34048K(306688K), 0.0488353 secs] 832582K->637643K(4160256K), 0.0488736 secs] [Times: user=0.17 sys=0.02, real=0.04 secs] 

2020-10-26T20:09:44.927-0800: [GC (Allocation Failure) 2020-10-26T20:09:44.927-0800: [ParNew: 306688K->34048K(306688K), 0.0470382 secs] 910283K->713324K(4160256K), 0.0470765 secs] [Times: user=0.16 sys=0.02, real=0.05 secs] 

2020-10-26T20:09:45.012-0800: [GC (Allocation Failure) 2020-10-26T20:09:45.012-0800: [ParNew: 306688K->34048K(306688K), 0.0467173 secs] 985964K->788393K(4160256K), 0.0467563 secs] [Times: user=0.16 sys=0.02, real=0.04 secs] 

2020-10-26T20:09:45.099-0800: [GC (Allocation Failure) 2020-10-26T20:09:45.099-0800: [ParNew: 306688K->34048K(306688K), 0.0466382 secs] 1061033K->862337K(4160256K), 0.0466875 secs] [Times: user=0.16 sys=0.02, real=0.05 secs] 

ִ执行结束！共生成对象次数:11387

Heap

 par new generation  total 306688K, used 45195K [0x00000006c0000000, 0x00000006d4cc0000, 0x00000006d4cc0000)

 eden space 272640K,  4% used [0x00000006c0000000, 0x00000006c0ae2e48, 0x00000006d0a40000)

 from space 34048K, 100% used [0x00000006d2b80000, 0x00000006d4cc0000, 0x00000006d4cc0000)

 to  space 34048K,  0% used [0x00000006d0a40000, 0x00000006d0a40000, 0x00000006d2b80000)

 concurrent mark-sweep generation total 3853568K, used 828289K [0x00000006d4cc0000, 0x00000007c0000000, 0x00000007c0000000)

 Metaspace    used 2732K, capacity 4486K, committed 4864K, reserved 1056768K

 class space  used 296K, capacity 386K, committed 512K, reserved 1048576K