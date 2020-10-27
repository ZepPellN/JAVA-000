simu@simudeiMac src % java GCLogAnalysis 

正在执行....

ִ执行结束！共生成对象次数:12096

simu@simudeiMac src % java -XX:+PrintGCDetails GCLogAnalysis 

正在执行....

[GC (Allocation Failure) [PSYoungGen: 49152K->8190K(57344K)] 49152K->14375K(188416K), 0.0047840 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

[GC (Allocation Failure) [PSYoungGen: 56866K->8189K(106496K)] 63050K->29398K(237568K), 0.0075129 secs] [Times: user=0.01 sys=0.02, real=0.01 secs] 

[GC (Allocation Failure) [PSYoungGen: 106493K->8174K(106496K)] 127702K->60381K(237568K), 0.0108454 secs] [Times: user=0.02 sys=0.02, real=0.01 secs] 

[GC (Allocation Failure) [PSYoungGen: 106478K->8190K(204800K)] 158685K->94340K(335872K), 0.0117142 secs] [Times: user=0.02 sys=0.03, real=0.01 secs] 

[GC (Allocation Failure) [PSYoungGen: 204798K->8191K(204800K)] 290948K->164107K(360960K), 0.0190912 secs] [Times: user=0.03 sys=0.04, real=0.02 secs] 

[Full GC (Ergonomics) [PSYoungGen: 8191K->0K(204800K)] [ParOldGen: 155916K->145854K(279040K)] 164107K->145854K(483840K), [Metaspace: 2725K->2725K(1056768K)], 0.0212681 secs] [Times: user=0.07 sys=0.00, real=0.02 secs] 

[GC (Allocation Failure) [PSYoungGen: 196608K->63678K(413696K)] 342462K->209533K(692736K), 0.0177537 secs] [Times: user=0.03 sys=0.04, real=0.02 secs] 

[GC (Allocation Failure) [PSYoungGen: 413374K->88062K(450048K)] 559229K->295598K(729088K), 0.0388284 secs] [Times: user=0.06 sys=0.09, real=0.04 secs] 

[Full GC (Ergonomics) [PSYoungGen: 88062K->0K(450048K)] [ParOldGen: 207535K->236744K(396800K)] 295598K->236744K(846848K), [Metaspace: 2725K->2725K(1056768K)], 0.0405508 secs] [Times: user=0.12 sys=0.01, real=0.04 secs] 

[GC (Allocation Failure) [PSYoungGen: 361984K->101418K(739328K)] 598728K->338162K(1136128K), 0.0289298 secs] [Times: user=0.04 sys=0.07, real=0.03 secs] 

[GC (Allocation Failure) [PSYoungGen: 705578K->144882K(749056K)] 942322K->460614K(1145856K), 0.0686991 secs] [Times: user=0.08 sys=0.17, real=0.07 secs] 

[Full GC (Ergonomics) [PSYoungGen: 144882K->0K(749056K)] [ParOldGen: 315732K->319327K(507904K)] 460614K->319327K(1256960K), [Metaspace: 2725K->2725K(1056768K)], 0.0540644 secs] [Times: user=0.18 sys=0.01, real=0.05 secs] 

[GC (Allocation Failure) [PSYoungGen: 603513K->160375K(813056K)] 922841K->479702K(1320960K), 0.0453113 secs] [Times: user=0.06 sys=0.11, real=0.04 secs] 

ִ执行结束！共生成对象次数:12223

Heap

 PSYoungGen   total 813056K, used 772727K [0x0000000780000000, 0x00000007c0000000, 0x00000007c0000000)

 eden space 612352K, 100% used [0x0000000780000000,0x00000007a5600000,0x00000007a5600000)

 from space 200704K, 79% used [0x00000007b3c00000,0x00000007bd89dc08,0x00000007c0000000)

 to  space 218112K, 0% used [0x00000007a5600000,0x00000007a5600000,0x00000007b2b00000)

 ParOldGen    total 507904K, used 319327K [0x0000000700000000, 0x000000071f000000, 0x0000000780000000)

 object space 507904K, 62% used [0x0000000700000000,0x00000007137d7f40,0x000000071f000000)

 Metaspace    used 2732K, capacity 4486K, committed 4864K, reserved 1056768K

 class space  used 296K, capacity 386K, committed 512K, reserved 1048576K

simu@simudeiMac src % java -Xms512m -Xmx512m -XX:+PrintGCDetails GCLogAnalysis

正在执行....

[GC (Allocation Failure) [PSYoungGen: 131584K->21499K(153088K)] 131584K->46945K(502784K), 0.0131402 secs] [Times: user=0.02 sys=0.03, real=0.02 secs] 

[GC (Allocation Failure) [PSYoungGen: 153083K->21499K(153088K)] 178529K->88786K(502784K), 0.0177363 secs] [Times: user=0.02 sys=0.04, real=0.02 secs] 

[GC (Allocation Failure) [PSYoungGen: 153083K->21495K(153088K)] 220370K->130295K(502784K), 0.0153561 secs] [Times: user=0.03 sys=0.03, real=0.02 secs] 

[GC (Allocation Failure) [PSYoungGen: 153079K->21502K(153088K)] 261879K->171966K(502784K), 0.0159411 secs] [Times: user=0.03 sys=0.03, real=0.01 secs] 

[GC (Allocation Failure) [PSYoungGen: 153086K->21488K(153088K)] 303550K->211686K(502784K), 0.0156804 secs] [Times: user=0.03 sys=0.03, real=0.02 secs] 

[GC (Allocation Failure) [PSYoungGen: 153072K->21494K(80384K)] 343270K->256135K(430080K), 0.0159796 secs] [Times: user=0.03 sys=0.02, real=0.02 secs] 

[GC (Allocation Failure) [PSYoungGen: 80374K->34128K(116736K)] 315015K->271098K(466432K), 0.0067176 secs] [Times: user=0.02 sys=0.00, real=0.00 secs] 

[GC (Allocation Failure) [PSYoungGen: 93008K->44499K(116736K)] 329978K->288421K(466432K), 0.0098208 secs] [Times: user=0.03 sys=0.00, real=0.01 secs] 

[GC (Allocation Failure) [PSYoungGen: 103273K->52829K(116736K)] 347195K->304993K(466432K), 0.0105344 secs] [Times: user=0.04 sys=0.01, real=0.01 secs] 

[GC (Allocation Failure) [PSYoungGen: 111236K->41995K(116736K)] 363400K->324297K(466432K), 0.0152369 secs] [Times: user=0.04 sys=0.02, real=0.02 secs] 

[GC (Allocation Failure) [PSYoungGen: 100795K->21125K(116736K)] 383098K->342052K(466432K), 0.0137298 secs] [Times: user=0.03 sys=0.02, real=0.01 secs] 

[Full GC (Ergonomics) [PSYoungGen: 21125K->0K(116736K)] [ParOldGen: 320927K->238996K(349696K)] 342052K->238996K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0445924 secs] [Times: user=0.14 sys=0.01, real=0.05 secs] 

[GC (Allocation Failure) [PSYoungGen: 58407K->20361K(116736K)] 297404K->259358K(466432K), 0.0037392 secs] [Times: user=0.02 sys=0.00, real=0.00 secs] 

[GC (Allocation Failure) [PSYoungGen: 79074K->19628K(116736K)] 318070K->278167K(466432K), 0.0063206 secs] [Times: user=0.03 sys=0.00, real=0.01 secs] 

[GC (Allocation Failure) [PSYoungGen: 78305K->21322K(116736K)] 336844K->298984K(466432K), 0.0066976 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 

[GC (Allocation Failure) [PSYoungGen: 80202K->21517K(116736K)] 357864K->318410K(466432K), 0.0086418 secs] [Times: user=0.03 sys=0.00, real=0.01 secs] 

[GC (Allocation Failure) [PSYoungGen: 80397K->17521K(116736K)] 377290K->334410K(466432K), 0.0076892 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 

[Full GC (Ergonomics) [PSYoungGen: 17521K->0K(116736K)] [ParOldGen: 316889K->270823K(349696K)] 334410K->270823K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0458481 secs] [Times: user=0.16 sys=0.00, real=0.04 secs] 

[GC (Allocation Failure) [PSYoungGen: 58880K->21748K(116736K)] 329703K->292571K(466432K), 0.0039879 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

[GC (Allocation Failure) [PSYoungGen: 80628K->23247K(116736K)] 351451K->313974K(466432K), 0.0078550 secs] [Times: user=0.03 sys=0.00, real=0.01 secs] 

[GC (Allocation Failure) [PSYoungGen: 82127K->16564K(116736K)] 372854K->328686K(466432K), 0.0079109 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 

[Full GC (Ergonomics) [PSYoungGen: 16564K->0K(116736K)] [ParOldGen: 312122K->288300K(349696K)] 328686K->288300K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0454153 secs] [Times: user=0.16 sys=0.00, real=0.04 secs] 

[GC (Allocation Failure) [PSYoungGen: 58880K->20080K(116736K)] 347180K->308381K(466432K), 0.0038112 secs] [Times: user=0.02 sys=0.00, real=0.00 secs] 

[GC (Allocation Failure) [PSYoungGen: 78794K->20525K(116736K)] 367095K->328557K(466432K), 0.0073401 secs] [Times: user=0.02 sys=0.00, real=0.00 secs] 

[GC (Allocation Failure) [PSYoungGen: 79107K->18978K(116736K)] 387139K->345576K(466432K), 0.0070880 secs] [Times: user=0.02 sys=0.01, real=0.01 secs] 

[Full GC (Ergonomics) [PSYoungGen: 18978K->0K(116736K)] [ParOldGen: 326598K->295802K(349696K)] 345576K->295802K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0509494 secs] [Times: user=0.18 sys=0.00, real=0.05 secs] 

[GC (Allocation Failure) [PSYoungGen: 58779K->22917K(116736K)] 354581K->318720K(466432K), 0.0042819 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

[GC (Allocation Failure) [PSYoungGen: 81797K->23185K(116736K)] 377600K->340604K(466432K), 0.0077859 secs] [Times: user=0.03 sys=0.00, real=0.01 secs] 

[Full GC (Ergonomics) [PSYoungGen: 23185K->0K(116736K)] [ParOldGen: 317418K->311950K(349696K)] 340604K->311950K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0497116 secs] [Times: user=0.18 sys=0.00, real=0.05 secs] 

[GC (Allocation Failure) [PSYoungGen: 58876K->19884K(116736K)] 370826K->331835K(466432K), 0.0036539 secs] [Times: user=0.02 sys=0.00, real=0.00 secs] 

[GC (Allocation Failure) [PSYoungGen: 78558K->17015K(116736K)] 390509K->347867K(466432K), 0.0069623 secs] [Times: user=0.02 sys=0.01, real=0.01 secs] 

[Full GC (Ergonomics) [PSYoungGen: 17015K->0K(116736K)] [ParOldGen: 330851K->318145K(349696K)] 347867K->318145K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0510771 secs] [Times: user=0.18 sys=0.00, real=0.05 secs] 

[Full GC (Ergonomics) [PSYoungGen: 58839K->0K(116736K)] [ParOldGen: 318145K->317642K(349696K)] 376985K->317642K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0513900 secs] [Times: user=0.18 sys=0.00, real=0.05 secs] 

[GC (Allocation Failure) [PSYoungGen: 58880K->16211K(116736K)] 376522K->333854K(466432K), 0.0031743 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

[GC (Allocation Failure) [PSYoungGen: 75012K->19151K(117760K)] 392655K->351364K(467456K), 0.0063694 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 

[Full GC (Ergonomics) [PSYoungGen: 19151K->0K(117760K)] [ParOldGen: 332213K->319037K(349696K)] 351364K->319037K(467456K), [Metaspace: 2725K->2725K(1056768K)], 0.0575999 secs] [Times: user=0.15 sys=0.01, real=0.06 secs] 

ִ执行结束！共生成对象次数:8100

Heap

 PSYoungGen   total 117760K, used 2666K [0x00000007b5580000, 0x00000007c0000000, 0x00000007c0000000)

 eden space 59904K, 4% used [0x00000007b5580000,0x00000007b581ab58,0x00000007b9000000)

 from space 57856K, 0% used [0x00000007bc780000,0x00000007bc780000,0x00000007c0000000)

 to  space 56832K, 0% used [0x00000007b9000000,0x00000007b9000000,0x00000007bc780000)

 ParOldGen    total 349696K, used 319037K [0x00000007a0000000, 0x00000007b5580000, 0x00000007b5580000)

 object space 349696K, 91% used [0x00000007a0000000,0x00000007b378f738,0x00000007b5580000)

 Metaspace    used 2732K, capacity 4486K, committed 4864K, reserved 1056768K

 class space  used 296K, capacity 386K, committed 512K, reserved 1048576K

simu@simudeiMac src % java -Xms4g -Xmx4g -XX:+PrintGCDetails GCLogAnalysis

正在执行....

[GC (Allocation Failure) [PSYoungGen: 1048576K->174582K(1223168K)] 1048576K->243552K(4019712K), 0.0743907 secs] [Times: user=0.10 sys=0.16, real=0.07 secs] 

[GC (Allocation Failure) [PSYoungGen: 1223158K->174586K(1223168K)] 1292128K->366573K(4019712K), 0.0802369 secs] [Times: user=0.11 sys=0.16, real=0.08 secs] 

ִ执行结束！共生成对象次数:11600

Heap

 PSYoungGen   total 1223168K, used 1189547K [0x000000076ab00000, 0x00000007c0000000, 0x00000007c0000000)

 eden space 1048576K, 96% used [0x000000076ab00000,0x00000007a8a2c2a8,0x00000007aab00000)

 from space 174592K, 99% used [0x00000007b5580000,0x00000007bfffe9a0,0x00000007c0000000)

 to  space 174592K, 0% used [0x00000007aab00000,0x00000007aab00000,0x00000007b5580000)

 ParOldGen    total 2796544K, used 191986K [0x00000006c0000000, 0x000000076ab00000, 0x000000076ab00000)

 object space 2796544K, 6% used [0x00000006c0000000,0x00000006cbb7cad8,0x000000076ab00000)

 Metaspace    used 2732K, capacity 4486K, committed 4864K, reserved 1056768K

 class space  used 296K, capacity 386K, committed 512K, reserved 1048576K

simu@simudeiMac src % clear



simu@simudeiMac src % java -XX:+UseSerialGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis 

正在执行....

2020-10-26T19:46:14.073-0800: [GC (Allocation Failure) 2020-10-26T19:46:14.073-0800: [DefNew: 139776K->17471K(157248K), 0.0219701 secs] 139776K->41779K(506816K), 0.0220065 secs] [Times: user=0.02 sys=0.01, real=0.02 secs] 

2020-10-26T19:46:14.121-0800: [GC (Allocation Failure) 2020-10-26T19:46:14.121-0800: [DefNew: 157245K->17471K(157248K), 0.0325674 secs] 181552K->88533K(506816K), 0.0326090 secs] [Times: user=0.02 sys=0.01, real=0.03 secs] 

2020-10-26T19:46:14.178-0800: [GC (Allocation Failure) 2020-10-26T19:46:14.178-0800: [DefNew: 157247K->17469K(157248K), 0.0252834 secs] 228309K->132584K(506816K), 0.0253169 secs] [Times: user=0.01 sys=0.01, real=0.03 secs] 

2020-10-26T19:46:14.227-0800: [GC (Allocation Failure) 2020-10-26T19:46:14.227-0800: [DefNew: 157245K->17471K(157248K), 0.0251141 secs] 272360K->178043K(506816K), 0.0251479 secs] [Times: user=0.01 sys=0.01, real=0.03 secs] 

2020-10-26T19:46:14.274-0800: [GC (Allocation Failure) 2020-10-26T19:46:14.274-0800: [DefNew: 157247K->17470K(157248K), 0.0271824 secs] 317819K->227156K(506816K), 0.0272157 secs] [Times: user=0.02 sys=0.01, real=0.03 secs] 

2020-10-26T19:46:14.325-0800: [GC (Allocation Failure) 2020-10-26T19:46:14.325-0800: [DefNew: 157246K->17470K(157248K), 0.0244598 secs] 366932K->271782K(506816K), 0.0244937 secs] [Times: user=0.01 sys=0.01, real=0.02 secs] 

2020-10-26T19:46:14.368-0800: [GC (Allocation Failure) 2020-10-26T19:46:14.369-0800: [DefNew: 157246K->17470K(157248K), 0.0252925 secs] 411558K->315433K(506816K), 0.0253279 secs] [Times: user=0.02 sys=0.01, real=0.03 secs] 

2020-10-26T19:46:14.415-0800: [GC (Allocation Failure) 2020-10-26T19:46:14.415-0800: [DefNew: 157246K->157246K(157248K), 0.0000160 secs]2020-10-26T19:46:14.415-0800: [Tenured: 297962K->265691K(349568K), 0.0416064 secs] 455209K->265691K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0416681 secs] [Times: user=0.04 sys=0.00, real=0.04 secs] 

2020-10-26T19:46:14.478-0800: [GC (Allocation Failure) 2020-10-26T19:46:14.478-0800: [DefNew: 139776K->17471K(157248K), 0.0078160 secs] 405467K->313747K(506816K), 0.0078505 secs] [Times: user=0.01 sys=0.00, real=0.01 secs] 

2020-10-26T19:46:14.508-0800: [GC (Allocation Failure) 2020-10-26T19:46:14.508-0800: [DefNew: 157247K->17471K(157248K), 0.0257983 secs] 453523K->361669K(506816K), 0.0258319 secs] [Times: user=0.02 sys=0.01, real=0.03 secs] 

2020-10-26T19:46:14.555-0800: [GC (Allocation Failure) 2020-10-26T19:46:14.555-0800: [DefNew: 157247K->157247K(157248K), 0.0000164 secs]2020-10-26T19:46:14.555-0800: [Tenured: 344197K->314879K(349568K), 0.0480246 secs] 501445K->314879K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0480941 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 

2020-10-26T19:46:14.621-0800: [GC (Allocation Failure) 2020-10-26T19:46:14.621-0800: [DefNew: 139776K->139776K(157248K), 0.0000143 secs]2020-10-26T19:46:14.621-0800: [Tenured: 314879K->327796K(349568K), 0.0500905 secs] 454655K->327796K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0501505 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 

2020-10-26T19:46:14.691-0800: [GC (Allocation Failure) 2020-10-26T19:46:14.691-0800: [DefNew: 139776K->139776K(157248K), 0.0000146 secs]2020-10-26T19:46:14.691-0800: [Tenured: 327796K->317101K(349568K), 0.0547216 secs] 467572K->317101K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0547799 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 

2020-10-26T19:46:14.764-0800: [GC (Allocation Failure) 2020-10-26T19:46:14.764-0800: [DefNew: 139237K->139237K(157248K), 0.0000162 secs]2020-10-26T19:46:14.764-0800: [Tenured: 317101K->339306K(349568K), 0.0332293 secs] 456339K->339306K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0333082 secs] [Times: user=0.03 sys=0.00, real=0.03 secs] 

2020-10-26T19:46:14.820-0800: [GC (Allocation Failure) 2020-10-26T19:46:14.820-0800: [DefNew: 139776K->139776K(157248K), 0.0000149 secs]2020-10-26T19:46:14.820-0800: [Tenured: 339306K->349022K(349568K), 0.0510992 secs] 479082K->349022K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0511577 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 

2020-10-26T19:46:14.889-0800: [GC (Allocation Failure) 2020-10-26T19:46:14.889-0800: [DefNew: 139452K->139452K(157248K), 0.0000145 secs]2020-10-26T19:46:14.889-0800: [Tenured: 349022K->347609K(349568K), 0.0513797 secs] 488474K->347609K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0514358 secs] [Times: user=0.06 sys=0.00, real=0.06 secs] 

2020-10-26T19:46:14.959-0800: [GC (Allocation Failure) 2020-10-26T19:46:14.959-0800: [DefNew: 139776K->139776K(157248K), 0.0000147 secs]2020-10-26T19:46:14.959-0800: [Tenured: 347609K->337296K(349568K), 0.0574089 secs] 487385K->337296K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0574647 secs] [Times: user=0.06 sys=0.00, real=0.06 secs] 

ִ执行结束！共生成对象次数:8835

Heap

 def new generation  total 157248K, used 6127K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)

 eden space 139776K,  4% used [0x00000007a0000000, 0x00000007a05fbd88, 0x00000007a8880000)

 from space 17472K,  0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)

 to  space 17472K,  0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)

 tenured generation  total 349568K, used 337296K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)

  the space 349568K, 96% used [0x00000007aaaa0000, 0x00000007bf404118, 0x00000007bf404200, 0x00000007c0000000)

 Metaspace    used 2732K, capacity 4486K, committed 4864K, reserved 1056768K

 class space  used 296K, capacity 386K, committed 512K, reserved 1048576K

simu@simudeiMac src % java -XX:+UseSerialGC -Xms4g -Xmx4g -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

正在执行....

2020-10-26T19:54:23.269-0800: [GC (Allocation Failure) 2020-10-26T19:54:23.269-0800: [DefNew: 1118528K->139776K(1258304K), 0.1305803 secs] 1118528K->246188K(4054528K), 0.1306141 secs] [Times: user=0.09 sys=0.05, real=0.13 secs] 

2020-10-26T19:54:23.586-0800: [GC (Allocation Failure) 2020-10-26T19:54:23.586-0800: [DefNew: 1258304K->139775K(1258304K), 0.1465603 secs] 1364716K->396073K(4054528K), 0.1465944 secs] [Times: user=0.09 sys=0.06, real=0.15 secs] 

ִ执行结束！共生成对象次数:8351

Heap

 def new generation  total 1258304K, used 184312K [0x00000006c0000000, 0x0000000715550000, 0x0000000715550000)

 eden space 1118528K,  3% used [0x00000006c0000000, 0x00000006c2b7e170, 0x0000000704450000)

 from space 139776K, 99% used [0x0000000704450000, 0x000000070cccfff8, 0x000000070ccd0000)

 to  space 139776K,  0% used [0x000000070ccd0000, 0x000000070ccd0000, 0x0000000715550000)

 tenured generation  total 2796224K, used 256297K [0x0000000715550000, 0x00000007c0000000, 0x00000007c0000000)

  the space 2796224K,  9% used [0x0000000715550000, 0x0000000724f9a760, 0x0000000724f9a800, 0x00000007c0000000)

 Metaspace    used 2732K, capacity 4486K, committed 4864K, reserved 1056768K

 class space  used 296K, capacity 386K, committed 512K, reserved 1048576K

simu@simudeiMac src % clear







































simu@simudeiMac src % java -XX:+UseParallelGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

正在执行....

2020-10-26T19:56:20.038-0800: [GC (Allocation Failure) [PSYoungGen: 131584K->21503K(153088K)] 131584K->45434K(502784K), 0.0122812 secs] [Times: user=0.02 sys=0.03, real=0.02 secs] 

2020-10-26T19:56:20.072-0800: [GC (Allocation Failure) [PSYoungGen: 153087K->21499K(153088K)] 177018K->84191K(502784K), 0.0174024 secs] [Times: user=0.02 sys=0.04, real=0.01 secs] 

2020-10-26T19:56:20.108-0800: [GC (Allocation Failure) [PSYoungGen: 153083K->21500K(153088K)] 215775K->123936K(502784K), 0.0137236 secs] [Times: user=0.03 sys=0.03, real=0.02 secs] 

2020-10-26T19:56:20.141-0800: [GC (Allocation Failure) [PSYoungGen: 153084K->21491K(153088K)] 255520K->173139K(502784K), 0.0163069 secs] [Times: user=0.03 sys=0.03, real=0.01 secs] 

2020-10-26T19:56:20.178-0800: [GC (Allocation Failure) [PSYoungGen: 152884K->21497K(153088K)] 304531K->213874K(502784K), 0.0140324 secs] [Times: user=0.02 sys=0.03, real=0.02 secs] 

2020-10-26T19:56:20.215-0800: [GC (Allocation Failure) [PSYoungGen: 153081K->21487K(80384K)] 345458K->252139K(430080K), 0.0136231 secs] [Times: user=0.03 sys=0.03, real=0.01 secs] 

2020-10-26T19:56:20.238-0800: [GC (Allocation Failure) [PSYoungGen: 80159K->35694K(116736K)] 310811K->271859K(466432K), 0.0064564 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 

2020-10-26T19:56:20.252-0800: [GC (Allocation Failure) [PSYoungGen: 94260K->49488K(116736K)] 330425K->293605K(466432K), 0.0089241 secs] [Times: user=0.03 sys=0.01, real=0.01 secs] 

2020-10-26T19:56:20.271-0800: [GC (Allocation Failure) [PSYoungGen: 108358K->57767K(116736K)] 352475K->308311K(466432K), 0.0096443 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 

2020-10-26T19:56:20.291-0800: [GC (Allocation Failure) [PSYoungGen: 116647K->39136K(116736K)] 367191K->327180K(466432K), 0.0162303 secs] [Times: user=0.04 sys=0.02, real=0.01 secs] 

2020-10-26T19:56:20.317-0800: [GC (Allocation Failure) [PSYoungGen: 98016K->24065K(116736K)] 386060K->348390K(466432K), 0.0124706 secs] [Times: user=0.02 sys=0.02, real=0.01 secs] 

2020-10-26T19:56:20.330-0800: [Full GC (Ergonomics) [PSYoungGen: 24065K->0K(116736K)] [ParOldGen: 324324K->249261K(349696K)] 348390K->249261K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0412043 secs] [Times: user=0.13 sys=0.01, real=0.04 secs] 

2020-10-26T19:56:20.380-0800: [GC (Allocation Failure) [PSYoungGen: 58458K->19611K(116736K)] 307719K->268872K(466432K), 0.0040445 secs] [Times: user=0.02 sys=0.00, real=0.00 secs] 

2020-10-26T19:56:20.394-0800: [GC (Allocation Failure) [PSYoungGen: 78491K->18463K(116736K)] 327752K->285442K(466432K), 0.0052556 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

2020-10-26T19:56:20.409-0800: [GC (Allocation Failure) [PSYoungGen: 77125K->20455K(116736K)] 344104K->303828K(466432K), 0.0069890 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 

2020-10-26T19:56:20.425-0800: [GC (Allocation Failure) [PSYoungGen: 79323K->21390K(116736K)] 362696K->324233K(466432K), 0.0061895 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 

2020-10-26T19:56:20.431-0800: [Full GC (Ergonomics) [PSYoungGen: 21390K->0K(116736K)] [ParOldGen: 302842K->276996K(349696K)] 324233K->276996K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0393484 secs] [Times: user=0.13 sys=0.00, real=0.04 secs] 

2020-10-26T19:56:20.479-0800: [GC (Allocation Failure) [PSYoungGen: 58607K->22663K(116736K)] 335604K->299659K(466432K), 0.0034851 secs] [Times: user=0.01 sys=0.00, real=0.01 secs] 

2020-10-26T19:56:20.489-0800: [GC (Allocation Failure) [PSYoungGen: 81540K->19920K(116736K)] 358536K->318713K(466432K), 0.0058354 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 

2020-10-26T19:56:20.502-0800: [GC (Allocation Failure) [PSYoungGen: 78760K->22827K(116736K)] 377553K->341491K(466432K), 0.0074881 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 

2020-10-26T19:56:20.510-0800: [Full GC (Ergonomics) [PSYoungGen: 22827K->0K(116736K)] [ParOldGen: 318664K->302840K(349696K)] 341491K->302840K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0432948 secs] [Times: user=0.14 sys=0.00, real=0.04 secs] 

2020-10-26T19:56:20.561-0800: [GC (Allocation Failure) [PSYoungGen: 58880K->18254K(116736K)] 361720K->321094K(466432K), 0.0039188 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

2020-10-26T19:56:20.574-0800: [GC (Allocation Failure) [PSYoungGen: 77134K->16409K(116736K)] 379974K->334621K(466432K), 0.0049175 secs] [Times: user=0.02 sys=0.00, real=0.00 secs] 

2020-10-26T19:56:20.579-0800: [Full GC (Ergonomics) [PSYoungGen: 16409K->0K(116736K)] [ParOldGen: 318211K->306574K(349696K)] 334621K->306574K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0421202 secs] [Times: user=0.15 sys=0.01, real=0.05 secs] 

2020-10-26T19:56:20.630-0800: [GC (Allocation Failure) [PSYoungGen: 58880K->19789K(116736K)] 365454K->326363K(466432K), 0.0031962 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

2020-10-26T19:56:20.642-0800: [GC (Allocation Failure) [PSYoungGen: 78669K->20618K(116736K)] 385243K->344899K(466432K), 0.0055835 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

2020-10-26T19:56:20.647-0800: [Full GC (Ergonomics) [PSYoungGen: 20618K->0K(116736K)] [ParOldGen: 324281K->315561K(349696K)] 344899K->315561K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0441374 secs] [Times: user=0.16 sys=0.00, real=0.05 secs] 

2020-10-26T19:56:20.699-0800: [Full GC (Ergonomics) [PSYoungGen: 58822K->0K(116736K)] [ParOldGen: 315561K->320978K(349696K)] 374383K->320978K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0403835 secs] [Times: user=0.14 sys=0.00, real=0.05 secs] 

2020-10-26T19:56:20.749-0800: [Full GC (Ergonomics) [PSYoungGen: 58880K->0K(116736K)] [ParOldGen: 320978K->324545K(349696K)] 379858K->324545K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0412566 secs] [Times: user=0.15 sys=0.00, real=0.05 secs] 

2020-10-26T19:56:20.800-0800: [Full GC (Ergonomics) [PSYoungGen: 58880K->0K(116736K)] [ParOldGen: 324545K->326139K(349696K)] 383425K->326139K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0420549 secs] [Times: user=0.14 sys=0.00, real=0.04 secs] 

2020-10-26T19:56:20.853-0800: [Full GC (Ergonomics) [PSYoungGen: 58539K->0K(116736K)] [ParOldGen: 326139K->328931K(349696K)] 384678K->328931K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0425284 secs] [Times: user=0.15 sys=0.01, real=0.04 secs] 

2020-10-26T19:56:20.905-0800: [Full GC (Ergonomics) [PSYoungGen: 58845K->0K(116736K)] [ParOldGen: 328931K->330117K(349696K)] 387776K->330117K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0452022 secs] [Times: user=0.16 sys=0.00, real=0.05 secs] 

2020-10-26T19:56:20.959-0800: [Full GC (Ergonomics) [PSYoungGen: 58508K->0K(116736K)] [ParOldGen: 330117K->335095K(349696K)] 388626K->335095K(466432K), [Metaspace: 2725K->2725K(1056768K)], 0.0441377 secs] [Times: user=0.15 sys=0.00, real=0.05 secs] 

ִ执行结束！共生成对象次数:7794

Heap

 PSYoungGen   total 116736K, used 2730K [0x00000007b5580000, 0x00000007c0000000, 0x00000007c0000000)

 eden space 58880K, 4% used [0x00000007b5580000,0x00000007b582abd8,0x00000007b8f00000)

 from space 57856K, 0% used [0x00000007bc780000,0x00000007bc780000,0x00000007c0000000)

 to  space 57856K, 0% used [0x00000007b8f00000,0x00000007b8f00000,0x00000007bc780000)

 ParOldGen    total 349696K, used 335095K [0x00000007a0000000, 0x00000007b5580000, 0x00000007b5580000)

 object space 349696K, 95% used [0x00000007a0000000,0x00000007b473df68,0x00000007b5580000)

 Metaspace    used 2732K, capacity 4486K, committed 4864K, reserved 1056768K

 class space  used 296K, capacity 386K, committed 512K, reserved 1048576K

simu@simudeiMac src % clear























simu@simudeiMac src % java -XX:+UseParallelGC -Xms4g -Xmx4g -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

正在执行....

2020-10-26T20:02:25.533-0800: [GC (Allocation Failure) [PSYoungGen: 1048576K->174576K(1223168K)] 1048576K->229519K(4019712K), 0.0705108 secs] [Times: user=0.08 sys=0.16, real=0.07 secs] 

2020-10-26T20:02:25.771-0800: [GC (Allocation Failure) [PSYoungGen: 1223152K->174590K(1223168K)] 1278095K->350756K(4019712K), 0.0896463 secs] [Times: user=0.10 sys=0.18, real=0.09 secs] 

2020-10-26T20:02:26.006-0800: [GC (Allocation Failure) [PSYoungGen: 1223166K->174578K(1223168K)] 1399332K->467843K(4019712K), 0.0580600 secs] [Times: user=0.13 sys=0.07, real=0.06 secs] 

ִ执行结束！共生成对象次数:11932

Heap

 PSYoungGen   total 1223168K, used 216553K [0x000000076ab00000, 0x00000007c0000000, 0x00000007c0000000)

 eden space 1048576K, 4% used [0x000000076ab00000,0x000000076d3fdc08,0x00000007aab00000)

 from space 174592K, 99% used [0x00000007aab00000,0x00000007b557ca40,0x00000007b5580000)

 to  space 174592K, 0% used [0x00000007b5580000,0x00000007b5580000,0x00000007c0000000)

 ParOldGen    total 2796544K, used 293265K [0x00000006c0000000, 0x000000076ab00000, 0x000000076ab00000)

 object space 2796544K, 10% used [0x00000006c0000000,0x00000006d1e645a0,0x000000076ab00000)

 Metaspace    used 2732K, capacity 4486K, committed 4864K, reserved 1056768K

 class space  used 296K, capacity 386K, committed 512K, reserved 1048576K

simu@simudeiMac src % java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

正在执行....

2020-10-26T20:04:31.033-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.034-0800: [ParNew: 139776K->17472K(157248K), 0.0120435 secs] 139776K->42737K(506816K), 0.0121369 secs] [Times: user=0.02 sys=0.03, real=0.01 secs] 

2020-10-26T20:04:31.066-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.066-0800: [ParNew: 157248K->17472K(157248K), 0.0177210 secs] 182513K->86711K(506816K), 0.0177589 secs] [Times: user=0.04 sys=0.03, real=0.02 secs] 

2020-10-26T20:04:31.106-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.106-0800: [ParNew: 157248K->17472K(157248K), 0.0222317 secs] 226487K->128414K(506816K), 0.0222692 secs] [Times: user=0.07 sys=0.01, real=0.02 secs] 

2020-10-26T20:04:31.150-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.150-0800: [ParNew: 157139K->17472K(157248K), 0.0224460 secs] 268082K->171621K(506816K), 0.0224853 secs] [Times: user=0.08 sys=0.02, real=0.02 secs] 

2020-10-26T20:04:31.193-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.193-0800: [ParNew: 157248K->17470K(157248K), 0.0251414 secs] 311397K->220039K(506816K), 0.0251814 secs] [Times: user=0.09 sys=0.01, real=0.02 secs] 

2020-10-26T20:04:31.218-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 202569K(349568K)] 223080K(506816K), 0.0001965 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.219-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:31.223-0800: [CMS-concurrent-mark: 0.005/0.005 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 

2020-10-26T20:04:31.224-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:31.224-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.224-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:31.240-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.240-0800: [ParNew: 157246K->17470K(157248K), 0.0236293 secs] 359815K->263281K(506816K), 0.0236675 secs] [Times: user=0.07 sys=0.01, real=0.02 secs] 

2020-10-26T20:04:31.283-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.283-0800: [ParNew: 157246K->17467K(157248K), 0.0241138 secs] 403057K->307712K(506816K), 0.0241523 secs] [Times: user=0.08 sys=0.01, real=0.02 secs] 

2020-10-26T20:04:31.327-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.327-0800: [ParNew: 157243K->17469K(157248K), 0.0216798 secs] 447488K->349034K(506816K), 0.0217182 secs] [Times: user=0.08 sys=0.01, real=0.02 secs] 

2020-10-26T20:04:31.349-0800: [CMS-concurrent-abortable-preclean: 0.004/0.125 secs] [Times: user=0.30 sys=0.03, real=0.12 secs] 

2020-10-26T20:04:31.350-0800: [GC (CMS Final Remark) [YG occupancy: 27163 K (157248 K)]2020-10-26T20:04:31.350-0800: [Rescan (parallel) , 0.0002876 secs]2020-10-26T20:04:31.350-0800: [weak refs processing, 0.0000131 secs]2020-10-26T20:04:31.350-0800: [class unloading, 0.0002181 secs]2020-10-26T20:04:31.350-0800: [scrub symbol table, 0.0003953 secs]2020-10-26T20:04:31.350-0800: [scrub string table, 0.0001634 secs][1 CMS-remark: 331564K(349568K)] 358727K(506816K), 0.0011384 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.351-0800: [CMS-concurrent-sweep-start]

2020-10-26T20:04:31.351-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.351-0800: [CMS-concurrent-reset-start]

2020-10-26T20:04:31.352-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.371-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.371-0800: [ParNew: 157245K->17471K(157248K), 0.0110450 secs] 448716K->352051K(506816K), 0.0110851 secs] [Times: user=0.04 sys=0.00, real=0.01 secs] 

2020-10-26T20:04:31.382-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 334579K(349568K)] 352163K(506816K), 0.0001523 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.382-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:31.385-0800: [CMS-concurrent-mark: 0.003/0.003 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.385-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:31.386-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.386-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:31.386-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.386-0800: [GC (CMS Final Remark) [YG occupancy: 40494 K (157248 K)]2020-10-26T20:04:31.386-0800: [Rescan (parallel) , 0.0012467 secs]2020-10-26T20:04:31.387-0800: [weak refs processing, 0.0000612 secs]2020-10-26T20:04:31.388-0800: [class unloading, 0.0002776 secs]2020-10-26T20:04:31.388-0800: [scrub symbol table, 0.0003039 secs]2020-10-26T20:04:31.388-0800: [scrub string table, 0.0001672 secs][1 CMS-remark: 334579K(349568K)] 375074K(506816K), 0.0021105 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.388-0800: [CMS-concurrent-sweep-start]

2020-10-26T20:04:31.390-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 

2020-10-26T20:04:31.390-0800: [CMS-concurrent-reset-start]

2020-10-26T20:04:31.391-0800: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.405-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.405-0800: [ParNew: 157247K->17471K(157248K), 0.0097650 secs] 388483K->291054K(506816K), 0.0098021 secs] [Times: user=0.04 sys=0.00, real=0.01 secs] 

2020-10-26T20:04:31.415-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 273583K(349568K)] 291126K(506816K), 0.0001630 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.415-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:31.417-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.417-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:31.418-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.418-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:31.436-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.436-0800: [ParNew: 157247K->17469K(157248K), 0.0124912 secs] 430830K->335061K(506816K), 0.0125595 secs] [Times: user=0.05 sys=0.00, real=0.01 secs] 

2020-10-26T20:04:31.468-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.468-0800: [ParNew: 157245K->157245K(157248K), 0.0000171 secs]2020-10-26T20:04:31.468-0800: [CMS2020-10-26T20:04:31.468-0800: [CMS-concurrent-abortable-preclean: 0.002/0.050 secs] [Times: user=0.09 sys=0.00, real=0.05 secs] 

 (concurrent mode failure): 317592K->281332K(349568K), 0.0491620 secs] 474837K->281332K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0492274 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 

2020-10-26T20:04:31.536-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.536-0800: [ParNew: 139776K->17470K(157248K), 0.0058237 secs] 421108K->317539K(506816K), 0.0058584 secs] [Times: user=0.02 sys=0.01, real=0.01 secs] 

2020-10-26T20:04:31.542-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 300068K(349568K)] 320355K(506816K), 0.0001346 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.543-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:31.545-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.545-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:31.545-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.545-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:31.566-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.566-0800: [ParNew: 156786K->17467K(157248K), 0.0136034 secs] 456855K->361819K(506816K), 0.0136407 secs] [Times: user=0.04 sys=0.00, real=0.02 secs] 

2020-10-26T20:04:31.580-0800: [CMS-concurrent-abortable-preclean: 0.000/0.035 secs] [Times: user=0.07 sys=0.00, real=0.04 secs] 

2020-10-26T20:04:31.580-0800: [GC (CMS Final Remark) [YG occupancy: 18260 K (157248 K)]2020-10-26T20:04:31.580-0800: [Rescan (parallel) , 0.0002877 secs]2020-10-26T20:04:31.581-0800: [weak refs processing, 0.0000101 secs]2020-10-26T20:04:31.581-0800: [class unloading, 0.0002009 secs]2020-10-26T20:04:31.581-0800: [scrub symbol table, 0.0002779 secs]2020-10-26T20:04:31.581-0800: [scrub string table, 0.0001327 secs][1 CMS-remark: 344352K(349568K)] 362612K(506816K), 0.0009632 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.581-0800: [CMS-concurrent-sweep-start]

2020-10-26T20:04:31.582-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.582-0800: [CMS-concurrent-reset-start]

2020-10-26T20:04:31.582-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.602-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.602-0800: [ParNew: 157243K->157243K(157248K), 0.0000165 secs]2020-10-26T20:04:31.602-0800: [CMS: 307035K->307483K(349568K), 0.0576097 secs] 464278K->307483K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0576934 secs] [Times: user=0.06 sys=0.00, real=0.06 secs] 

2020-10-26T20:04:31.660-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 307483K(349568K)] 310281K(506816K), 0.0001388 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.660-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:31.662-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.662-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:31.663-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.663-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:31.678-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.678-0800: [ParNew: 139217K->17470K(157248K), 0.0069712 secs] 446701K->351879K(506816K), 0.0070096 secs] [Times: user=0.03 sys=0.00, real=0.01 secs] 

2020-10-26T20:04:31.685-0800: [CMS-concurrent-abortable-preclean: 0.000/0.023 secs] [Times: user=0.05 sys=0.00, real=0.02 secs] 

2020-10-26T20:04:31.686-0800: [GC (CMS Final Remark) [YG occupancy: 18082 K (157248 K)]2020-10-26T20:04:31.686-0800: [Rescan (parallel) , 0.0003130 secs]2020-10-26T20:04:31.686-0800: [weak refs processing, 0.0000100 secs]2020-10-26T20:04:31.686-0800: [class unloading, 0.0001980 secs]2020-10-26T20:04:31.686-0800: [scrub symbol table, 0.0002719 secs]2020-10-26T20:04:31.686-0800: [scrub string table, 0.0001331 secs][1 CMS-remark: 334409K(349568K)] 352491K(506816K), 0.0009643 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.687-0800: [CMS-concurrent-sweep-start]

2020-10-26T20:04:31.687-0800: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.687-0800: [CMS-concurrent-reset-start]

2020-10-26T20:04:31.688-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.710-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.710-0800: [ParNew: 157035K->157035K(157248K), 0.0000207 secs]2020-10-26T20:04:31.710-0800: [CMS: 332849K->322369K(349568K), 0.0596182 secs] 489884K->322369K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0597008 secs] [Times: user=0.06 sys=0.00, real=0.05 secs] 

2020-10-26T20:04:31.770-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 322369K(349568K)] 322825K(506816K), 0.0002051 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.770-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:31.772-0800: [CMS-concurrent-mark: 0.003/0.003 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.772-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:31.773-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.773-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:31.789-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.789-0800: [ParNew: 139776K->139776K(157248K), 0.0000182 secs]2020-10-26T20:04:31.789-0800: [CMS2020-10-26T20:04:31.790-0800: [CMS-concurrent-abortable-preclean: 0.000/0.016 secs] [Times: user=0.01 sys=0.00, real=0.02 secs] 

 (concurrent mode failure): 322369K->332919K(349568K), 0.0615692 secs] 462145K->332919K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0616410 secs] [Times: user=0.06 sys=0.00, real=0.07 secs] 

2020-10-26T20:04:31.869-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.869-0800: [ParNew: 139776K->139776K(157248K), 0.0000165 secs]2020-10-26T20:04:31.869-0800: [CMS: 332919K->338946K(349568K), 0.0604495 secs] 472695K->338946K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0605166 secs] [Times: user=0.06 sys=0.00, real=0.06 secs] 

2020-10-26T20:04:31.929-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 338946K(349568K)] 339170K(506816K), 0.0002066 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 

2020-10-26T20:04:31.930-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:31.932-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.932-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:31.932-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.932-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:31.932-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.933-0800: [GC (CMS Final Remark) [YG occupancy: 25296 K (157248 K)]2020-10-26T20:04:31.933-0800: [Rescan (parallel) , 0.0002532 secs]2020-10-26T20:04:31.933-0800: [weak refs processing, 0.0000112 secs]2020-10-26T20:04:31.933-0800: [class unloading, 0.0001984 secs]2020-10-26T20:04:31.933-0800: [scrub symbol table, 0.0003156 secs]2020-10-26T20:04:31.933-0800: [scrub string table, 0.0001633 secs][1 CMS-remark: 338946K(349568K)] 364242K(506816K), 0.0009852 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.934-0800: [CMS-concurrent-sweep-start]

2020-10-26T20:04:31.934-0800: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.934-0800: [CMS-concurrent-reset-start]

2020-10-26T20:04:31.935-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:31.948-0800: [GC (Allocation Failure) 2020-10-26T20:04:31.948-0800: [ParNew: 139705K->139705K(157248K), 0.0000167 secs]2020-10-26T20:04:31.948-0800: [CMS: 338547K->344980K(349568K), 0.0602781 secs] 478253K->344980K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0603567 secs] [Times: user=0.06 sys=0.00, real=0.06 secs] 

2020-10-26T20:04:32.008-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 344980K(349568K)] 345576K(506816K), 0.0002217 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:32.009-0800: [CMS-concurrent-mark-start]

ִ执行结束！共生成对象次数:10665

Heap

 par new generation  total 157248K, used 6153K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)

 eden space 139776K,  4% used [0x00000007a0000000, 0x00000007a0602758, 0x00000007a8880000)

 from space 17472K,  0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)

 to  space 17472K,  0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)

 concurrent mark-sweep generation total 349568K, used 344980K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)

 Metaspace    used 2732K, capacity 4486K, committed 4864K, reserved 1056768K

 class space  used 296K, capacity 386K, committed 512K, reserved 1048576K

simu@simudeiMac src % clear



simu@simudeiMac src % java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

正在执行....

2020-10-26T20:04:42.283-0800: [GC (Allocation Failure) 2020-10-26T20:04:42.283-0800: [ParNew: 139776K->17472K(157248K), 0.0143479 secs] 139776K->49334K(506816K), 0.0143957 secs] [Times: user=0.03 sys=0.04, real=0.01 secs] 

2020-10-26T20:04:42.321-0800: [GC (Allocation Failure) 2020-10-26T20:04:42.321-0800: [ParNew: 157248K->17472K(157248K), 0.0166746 secs] 189110K->92544K(506816K), 0.0167101 secs] [Times: user=0.03 sys=0.03, real=0.01 secs] 

2020-10-26T20:04:42.357-0800: [GC (Allocation Failure) 2020-10-26T20:04:42.357-0800: [ParNew: 157015K->17472K(157248K), 0.0257677 secs] 232087K->140799K(506816K), 0.0258047 secs] [Times: user=0.09 sys=0.01, real=0.03 secs] 

2020-10-26T20:04:42.401-0800: [GC (Allocation Failure) 2020-10-26T20:04:42.401-0800: [ParNew: 157248K->17466K(157248K), 0.0289334 secs] 280575K->193142K(506816K), 0.0289753 secs] [Times: user=0.10 sys=0.01, real=0.03 secs] 

2020-10-26T20:04:42.430-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 175675K(349568K)] 195952K(506816K), 0.0001937 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:42.431-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:42.434-0800: [CMS-concurrent-mark: 0.004/0.004 secs] [Times: user=0.00 sys=0.01, real=0.00 secs] 

2020-10-26T20:04:42.435-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:42.435-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:42.435-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:42.454-0800: [GC (Allocation Failure) 2020-10-26T20:04:42.454-0800: [ParNew: 157194K->17472K(157248K), 0.0247684 secs] 332870K->236494K(506816K), 0.0248056 secs] [Times: user=0.09 sys=0.01, real=0.02 secs] 

2020-10-26T20:04:42.500-0800: [GC (Allocation Failure) 2020-10-26T20:04:42.500-0800: [ParNew: 157248K->17471K(157248K), 0.0245014 secs] 376270K->280279K(506816K), 0.0245378 secs] [Times: user=0.09 sys=0.01, real=0.02 secs] 

2020-10-26T20:04:42.544-0800: [GC (Allocation Failure) 2020-10-26T20:04:42.544-0800: [ParNew: 157099K->17471K(157248K), 0.0256822 secs] 419908K->327385K(506816K), 0.0257247 secs] [Times: user=0.08 sys=0.01, real=0.03 secs] 

2020-10-26T20:04:42.588-0800: [GC (Allocation Failure) 2020-10-26T20:04:42.588-0800: [ParNew: 157247K->157247K(157248K), 0.0000168 secs]2020-10-26T20:04:42.588-0800: [CMS2020-10-26T20:04:42.588-0800: [CMS-concurrent-abortable-preclean: 0.004/0.153 secs] [Times: user=0.34 sys=0.03, real=0.15 secs] 

 (concurrent mode failure): 309914K->247571K(349568K), 0.0445841 secs] 467161K->247571K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0446483 secs] [Times: user=0.04 sys=0.00, real=0.05 secs] 

2020-10-26T20:04:42.653-0800: [GC (Allocation Failure) 2020-10-26T20:04:42.653-0800: [ParNew: 139764K->17470K(157248K), 0.0083766 secs] 387335K->295952K(506816K), 0.0084148 secs] [Times: user=0.03 sys=0.00, real=0.01 secs] 

2020-10-26T20:04:42.662-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 278482K(349568K)] 298764K(506816K), 0.0001632 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:42.662-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:42.664-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:42.664-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:42.665-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:42.665-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:42.684-0800: [GC (Allocation Failure) 2020-10-26T20:04:42.684-0800: [ParNew: 157246K->17470K(157248K), 0.0127610 secs] 435728K->339099K(506816K), 0.0127984 secs] [Times: user=0.04 sys=0.00, real=0.01 secs] 

2020-10-26T20:04:42.716-0800: [GC (Allocation Failure) 2020-10-26T20:04:42.716-0800: [ParNew: 157246K->157246K(157248K), 0.0000169 secs]2020-10-26T20:04:42.716-0800: [CMS2020-10-26T20:04:42.716-0800: [CMS-concurrent-abortable-preclean: 0.002/0.051 secs] [Times: user=0.09 sys=0.00, real=0.05 secs] 

 (concurrent mode failure): 321628K->280350K(349568K), 0.0454740 secs] 478875K->280350K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0455426 secs] [Times: user=0.04 sys=0.00, real=0.05 secs] 

2020-10-26T20:04:42.779-0800: [GC (Allocation Failure) 2020-10-26T20:04:42.779-0800: [ParNew: 139776K->17471K(157248K), 0.0069824 secs] 420126K->325359K(506816K), 0.0070200 secs] [Times: user=0.03 sys=0.00, real=0.01 secs] 

2020-10-26T20:04:42.786-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 307887K(349568K)] 325546K(506816K), 0.0001424 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:42.786-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:42.788-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:42.788-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:42.789-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:42.789-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:42.806-0800: [GC (Allocation Failure) 2020-10-26T20:04:42.806-0800: [ParNew (promotion failed): 157000K->157000K(157248K), 0.0197020 secs]2020-10-26T20:04:42.825-0800: [CMS2020-10-26T20:04:42.825-0800: [CMS-concurrent-abortable-preclean: 0.000/0.037 secs] [Times: user=0.08 sys=0.01, real=0.04 secs] 

 (concurrent mode failure): 349257K->299094K(349568K), 0.0484421 secs] 464887K->299094K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0682267 secs] [Times: user=0.11 sys=0.01, real=0.07 secs] 

2020-10-26T20:04:42.893-0800: [GC (Allocation Failure) 2020-10-26T20:04:42.893-0800: [ParNew: 139776K->139776K(157248K), 0.0000167 secs]2020-10-26T20:04:42.893-0800: [CMS: 299094K->312534K(349568K), 0.0478797 secs] 438870K->312534K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0479452 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 

2020-10-26T20:04:42.941-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 312534K(349568K)] 315364K(506816K), 0.0001531 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:42.941-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:42.943-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:42.943-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:42.944-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:42.944-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:42.959-0800: [GC (Allocation Failure) 2020-10-26T20:04:42.959-0800: [ParNew: 139776K->139776K(157248K), 0.0000489 secs]2020-10-26T20:04:42.959-0800: [CMS2020-10-26T20:04:42.959-0800: [CMS-concurrent-abortable-preclean: 0.000/0.016 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 

 (concurrent mode failure): 312534K->321775K(349568K), 0.0504715 secs] 452310K->321775K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0505725 secs] [Times: user=0.05 sys=0.00, real=0.06 secs] 

2020-10-26T20:04:43.027-0800: [GC (Allocation Failure) 2020-10-26T20:04:43.027-0800: [ParNew: 139776K->139776K(157248K), 0.0000291 secs]2020-10-26T20:04:43.027-0800: [CMS: 321775K->334093K(349568K), 0.0526176 secs] 461551K->334093K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0526984 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 

2020-10-26T20:04:43.080-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 334093K(349568K)] 334244K(506816K), 0.0002129 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:43.080-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:43.082-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:43.082-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:43.082-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:43.082-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:43.082-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:43.083-0800: [GC (CMS Final Remark) [YG occupancy: 19943 K (157248 K)]2020-10-26T20:04:43.083-0800: [Rescan (parallel) , 0.0002551 secs]2020-10-26T20:04:43.083-0800: [weak refs processing, 0.0000103 secs]2020-10-26T20:04:43.083-0800: [class unloading, 0.0001971 secs]2020-10-26T20:04:43.083-0800: [scrub symbol table, 0.0002757 secs]2020-10-26T20:04:43.083-0800: [scrub string table, 0.0001892 secs][1 CMS-remark: 334093K(349568K)] 354037K(506816K), 0.0009854 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:43.084-0800: [CMS-concurrent-sweep-start]

2020-10-26T20:04:43.084-0800: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:43.084-0800: [CMS-concurrent-reset-start]

2020-10-26T20:04:43.084-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:43.101-0800: [GC (Allocation Failure) 2020-10-26T20:04:43.101-0800: [ParNew: 139776K->139776K(157248K), 0.0000189 secs]2020-10-26T20:04:43.101-0800: [CMS: 333349K->332133K(349568K), 0.0539150 secs] 473125K->332133K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0539881 secs] [Times: user=0.06 sys=0.00, real=0.05 secs] 

2020-10-26T20:04:43.155-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 332133K(349568K)] 332421K(506816K), 0.0002040 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:43.155-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:43.157-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:43.157-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:43.158-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:43.158-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:43.158-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:43.158-0800: [GC (CMS Final Remark) [YG occupancy: 23249 K (157248 K)]2020-10-26T20:04:43.158-0800: [Rescan (parallel) , 0.0002935 secs]2020-10-26T20:04:43.159-0800: [weak refs processing, 0.0000119 secs]2020-10-26T20:04:43.159-0800: [class unloading, 0.0002177 secs]2020-10-26T20:04:43.159-0800: [scrub symbol table, 0.0003165 secs]2020-10-26T20:04:43.159-0800: [scrub string table, 0.0001641 secs][1 CMS-remark: 332133K(349568K)] 355383K(506816K), 0.0010652 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:43.159-0800: [CMS-concurrent-sweep-start]

2020-10-26T20:04:43.160-0800: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 

2020-10-26T20:04:43.160-0800: [CMS-concurrent-reset-start]

2020-10-26T20:04:43.160-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:43.175-0800: [GC (Allocation Failure) 2020-10-26T20:04:43.175-0800: [ParNew: 139494K->139494K(157248K), 0.0000352 secs]2020-10-26T20:04:43.175-0800: [CMS: 331157K->334468K(349568K), 0.0593113 secs] 470652K->334468K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0594121 secs] [Times: user=0.06 sys=0.00, real=0.06 secs] 

2020-10-26T20:04:43.234-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 334468K(349568K)] 335115K(506816K), 0.0001732 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:43.235-0800: [CMS-concurrent-mark-start]

ִ执行结束！共生成对象次数:9594

Heap

 par new generation  total 157248K, used 6205K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)

 eden space 139776K,  4% used [0x00000007a0000000, 0x00000007a060f720, 0x00000007a8880000)

 from space 17472K,  0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)

 to  space 17472K,  0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)

 concurrent mark-sweep generation total 349568K, used 334468K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)

 Metaspace    used 2732K, capacity 4486K, committed 4864K, reserved 1056768K

 class space  used 296K, capacity 386K, committed 512K, reserved 1048576K

simu@simudeiMac src % clear



simu@simudeiMac src % java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

正在执行....

2020-10-26T20:04:58.873-0800: [GC (Allocation Failure) 2020-10-26T20:04:58.874-0800: [ParNew: 139776K->17472K(157248K), 0.0135671 secs] 139776K->51500K(506816K), 0.0136148 secs] [Times: user=0.02 sys=0.03, real=0.01 secs] 

2020-10-26T20:04:58.907-0800: [GC (Allocation Failure) 2020-10-26T20:04:58.907-0800: [ParNew: 157248K->17472K(157248K), 0.0166355 secs] 191276K->96091K(506816K), 0.0166716 secs] [Times: user=0.03 sys=0.03, real=0.02 secs] 

2020-10-26T20:04:58.942-0800: [GC (Allocation Failure) 2020-10-26T20:04:58.942-0800: [ParNew: 157248K->17472K(157248K), 0.0247217 secs] 235867K->142607K(506816K), 0.0247618 secs] [Times: user=0.08 sys=0.01, real=0.02 secs] 

2020-10-26T20:04:58.987-0800: [GC (Allocation Failure) 2020-10-26T20:04:58.987-0800: [ParNew: 157172K->17472K(157248K), 0.0240702 secs] 282308K->188001K(506816K), 0.0241073 secs] [Times: user=0.08 sys=0.01, real=0.03 secs] 

2020-10-26T20:04:59.034-0800: [GC (Allocation Failure) 2020-10-26T20:04:59.034-0800: [ParNew: 157248K->17470K(157248K), 0.0258453 secs] 327777K->234447K(506816K), 0.0258823 secs] [Times: user=0.08 sys=0.01, real=0.02 secs] 

2020-10-26T20:04:59.060-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 216977K(349568K)] 234735K(506816K), 0.0001991 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.060-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:59.065-0800: [CMS-concurrent-mark: 0.005/0.005 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.065-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:59.065-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.065-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:59.083-0800: [GC (Allocation Failure) 2020-10-26T20:04:59.083-0800: [ParNew: 157246K->17471K(157248K), 0.0232274 secs] 374223K->276029K(506816K), 0.0232649 secs] [Times: user=0.08 sys=0.01, real=0.02 secs] 

2020-10-26T20:04:59.128-0800: [GC (Allocation Failure) 2020-10-26T20:04:59.128-0800: [ParNew: 157247K->17469K(157248K), 0.0259252 secs] 415805K->321048K(506816K), 0.0259705 secs] [Times: user=0.08 sys=0.02, real=0.03 secs] 

2020-10-26T20:04:59.174-0800: [GC (Allocation Failure) 2020-10-26T20:04:59.174-0800: [ParNew: 156932K->156932K(157248K), 0.0000160 secs]2020-10-26T20:04:59.174-0800: [CMS2020-10-26T20:04:59.174-0800: [CMS-concurrent-abortable-preclean: 0.003/0.108 secs] [Times: user=0.22 sys=0.03, real=0.11 secs] 

 (concurrent mode failure): 303579K->250181K(349568K), 0.0494541 secs] 460511K->250181K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0495235 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 

2020-10-26T20:04:59.240-0800: [GC (Allocation Failure) 2020-10-26T20:04:59.240-0800: [ParNew: 139637K->17471K(157248K), 0.0073284 secs] 389818K->293483K(506816K), 0.0073643 secs] [Times: user=0.03 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.248-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 276011K(349568K)] 293672K(506816K), 0.0001914 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.248-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:59.250-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 

2020-10-26T20:04:59.250-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:59.250-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.250-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:59.270-0800: [GC (Allocation Failure) 2020-10-26T20:04:59.270-0800: [ParNew: 157247K->17470K(157248K), 0.0171284 secs] 433259K->334782K(506816K), 0.0171722 secs] [Times: user=0.07 sys=0.00, real=0.01 secs] 

2020-10-26T20:04:59.305-0800: [GC (Allocation Failure) 2020-10-26T20:04:59.305-0800: [ParNew: 157089K->157089K(157248K), 0.0000235 secs]2020-10-26T20:04:59.305-0800: [CMS2020-10-26T20:04:59.305-0800: [CMS-concurrent-abortable-preclean: 0.002/0.055 secs] [Times: user=0.11 sys=0.00, real=0.05 secs] 

 (concurrent mode failure): 317311K->288203K(349568K), 0.0660979 secs] 474401K->288203K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0661848 secs] [Times: user=0.06 sys=0.00, real=0.07 secs] 

2020-10-26T20:04:59.390-0800: [GC (Allocation Failure) 2020-10-26T20:04:59.390-0800: [ParNew: 139776K->17467K(157248K), 0.0075419 secs] 427979K->333747K(506816K), 0.0075771 secs] [Times: user=0.03 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.398-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 316280K(349568K)] 336748K(506816K), 0.0001583 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.398-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:59.400-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 

2020-10-26T20:04:59.400-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:59.400-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.400-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:59.400-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.400-0800: [GC (CMS Final Remark) [YG occupancy: 38179 K (157248 K)]2020-10-26T20:04:59.400-0800: [Rescan (parallel) , 0.0002734 secs]2020-10-26T20:04:59.401-0800: [weak refs processing, 0.0000108 secs]2020-10-26T20:04:59.401-0800: [class unloading, 0.0001929 secs]2020-10-26T20:04:59.401-0800: [scrub symbol table, 0.0003211 secs]2020-10-26T20:04:59.401-0800: [scrub string table, 0.0001338 secs][1 CMS-remark: 316280K(349568K)] 354459K(506816K), 0.0009751 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.401-0800: [CMS-concurrent-sweep-start]

2020-10-26T20:04:59.402-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.402-0800: [CMS-concurrent-reset-start]

2020-10-26T20:04:59.402-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.421-0800: [GC (Allocation Failure) 2020-10-26T20:04:59.422-0800: [ParNew: 157243K->17471K(157248K), 0.0178459 secs] 439583K->346505K(506816K), 0.0178889 secs] [Times: user=0.06 sys=0.01, real=0.01 secs] 

2020-10-26T20:04:59.440-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 329034K(349568K)] 347119K(506816K), 0.0001117 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.440-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:59.442-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.442-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:59.442-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.442-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:59.442-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.442-0800: [GC (CMS Final Remark) [YG occupancy: 36308 K (157248 K)]2020-10-26T20:04:59.442-0800: [Rescan (parallel) , 0.0002787 secs]2020-10-26T20:04:59.443-0800: [weak refs processing, 0.0000104 secs]2020-10-26T20:04:59.443-0800: [class unloading, 0.0001942 secs]2020-10-26T20:04:59.443-0800: [scrub symbol table, 0.0003075 secs]2020-10-26T20:04:59.443-0800: [scrub string table, 0.0001629 secs][1 CMS-remark: 329034K(349568K)] 365342K(506816K), 0.0009954 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.443-0800: [CMS-concurrent-sweep-start]

2020-10-26T20:04:59.444-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.444-0800: [CMS-concurrent-reset-start]

2020-10-26T20:04:59.445-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.462-0800: [GC (Allocation Failure) 2020-10-26T20:04:59.462-0800: [ParNew: 157247K->157247K(157248K), 0.0000262 secs]2020-10-26T20:04:59.462-0800: [CMS: 291052K->310290K(349568K), 0.0604456 secs] 448299K->310290K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0605481 secs] [Times: user=0.06 sys=0.00, real=0.06 secs] 

2020-10-26T20:04:59.523-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 310290K(349568K)] 310948K(506816K), 0.0001956 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.523-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:59.526-0800: [CMS-concurrent-mark: 0.003/0.003 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.526-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:59.527-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.527-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:59.544-0800: [GC (Allocation Failure) 2020-10-26T20:04:59.544-0800: [ParNew: 139776K->139776K(157248K), 0.0000168 secs]2020-10-26T20:04:59.544-0800: [CMS2020-10-26T20:04:59.544-0800: [CMS-concurrent-abortable-preclean: 0.001/0.017 secs] [Times: user=0.02 sys=0.00, real=0.02 secs] 

 (concurrent mode failure): 310290K->318477K(349568K), 0.0573824 secs] 450066K->318477K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0574477 secs] [Times: user=0.06 sys=0.00, real=0.06 secs] 

2020-10-26T20:04:59.619-0800: [GC (Allocation Failure) 2020-10-26T20:04:59.619-0800: [ParNew: 139776K->139776K(157248K), 0.0000170 secs]2020-10-26T20:04:59.619-0800: [CMS: 318477K->324213K(349568K), 0.0578921 secs] 458253K->324213K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0579632 secs] [Times: user=0.05 sys=0.00, real=0.06 secs] 

2020-10-26T20:04:59.678-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 324213K(349568K)] 324803K(506816K), 0.0001700 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.678-0800: [CMS-concurrent-mark-start]

2020-10-26T20:04:59.680-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.01 sys=0.00, real=0.01 secs] 

2020-10-26T20:04:59.680-0800: [CMS-concurrent-preclean-start]

2020-10-26T20:04:59.681-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.681-0800: [CMS-concurrent-abortable-preclean-start]

2020-10-26T20:04:59.696-0800: [GC (Allocation Failure) 2020-10-26T20:04:59.696-0800: [ParNew: 139776K->139776K(157248K), 0.0000163 secs]2020-10-26T20:04:59.696-0800: [CMS2020-10-26T20:04:59.697-0800: [CMS-concurrent-abortable-preclean: 0.000/0.016 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 

 (concurrent mode failure): 324213K->326334K(349568K), 0.0592805 secs] 463989K->326334K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0593459 secs] [Times: user=0.05 sys=0.00, real=0.06 secs] 

2020-10-26T20:04:59.773-0800: [GC (Allocation Failure) 2020-10-26T20:04:59.773-0800: [ParNew: 139725K->139725K(157248K), 0.0000165 secs]2020-10-26T20:04:59.773-0800: [CMS: 326334K->343418K(349568K), 0.0656006 secs] 466060K->343418K(506816K), [Metaspace: 2725K->2725K(1056768K)], 0.0656657 secs] [Times: user=0.06 sys=0.00, real=0.06 secs] 

2020-10-26T20:04:59.839-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 343418K(349568K)] 343558K(506816K), 0.0001941 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

2020-10-26T20:04:59.839-0800: [CMS-concurrent-mark-start]

ִ执行结束！共生成对象次数:9551

Heap

 par new generation  total 157248K, used 5714K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)

 eden space 139776K,  4% used [0x00000007a0000000, 0x00000007a0594a50, 0x00000007a8880000)

 from space 17472K,  0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)

 to  space 17472K,  0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)

 concurrent mark-sweep generation total 349568K, used 343418K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)

 Metaspace    used 2732K, capacity 4486K, committed 4864K, reserved 1056768K

 class space  used 296K, capacity 386K, committed 512K, reserved 1048576K

simu@simudeiMac src % 