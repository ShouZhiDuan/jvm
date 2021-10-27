# 测试学习服务器
* IP
`192.168.10.16` 
* 工作目录
`/usr/local/java-work`


# 启动jar操作 
* springboot参数放在jar包之后
nohup java -jar jvm.jar --spring.profiles.active=prod > jvm.log 2>&1 &
* jvm参数放在jar包之前
nohup java -jar -Xverify:none jvm.jar  > jvm.log 2>&1 & (参数-Xverify:none生效)
注意：
nohup java -jar jvm.jar  -Xverify:none  > jvm.log 2>&1 &(参数-Xverify:none放在jar之后，可以启动成功但是参数-Xverify:none不会生效)
* 多参数启动实例
nohup java -jar \
-Djava.rmi.server.hostname=192.168.10.16 \
-Dcom.sun.management.jmxremote \
-Dcom.sun.management.jmxremote.rmi.port=7098 \
-Dcom.sun.management.jmxremote.port=7099 \ 
-Dcom.sun.management.jmxremote.authenticate=false \
-Dcom.sun.management.jmxremote.ssl=false \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=/tmp/gc.hprof \
-Xverify:none \
-XX:+PrintCommandLineFlags \
jvm.jar  > jvm.log 2>&1 & 


# 查看当前java进程虚拟机参数列表
* jps -v | grep (进程ID/jar名称)
* 工具Java VisualVN也可以查看


# JVM常用参数 全局参数：jvm系统默认参数，也可以用在单个jvm进程中。
1、符号引用验证(类加载连接过程有个这个阶段)
* -Xverify:none  [进程参数]

2、输出垃圾回收日志详情
* -XX:+PrintGCDetails  [全局参数](https://blog.csdn.net/lanwp5302/article/details/100183369)

3、输出JVM命令行中的参数列表
* -XX:+PrintCommandLineFlags  [全局参数](https://blog.csdn.net/lanwp5302/article/details/100183369) 
开启启动jar输出jvm相关参数。例如堆大小设置、垃圾收集器等相关参数如下：
***
-XX:+PrintFlagsFinal 获取所有参数
-XX:+PrintCommandLineFlags 获取所有命令中的参数
***
-XX:-BytecodeVerificationLocal 
***
-XX:-BytecodeVerificationRemote 
***
-XX:G1ConcRefinementThreads=8 
***
-XX:GCDrainStackTargetSize=64 
***
* -XX:+HeapDumpOnOutOfMemoryError 
* -XX:HeapDumpPath=/tmp/gc.hprof  当出现内存溢出，输出堆栈日志。
***
-XX:InitialHeapSize=260254336(-Xms20M)  初始化堆的最小值 单位：byte
***
-XX:+ManagementServer 
***
-XX:MaxHeapSize=4164069376(-Xmx20M)  初始化堆的最大值 单位：byte
***
-XX:+PrintCommandLineFlags 输出JVM默认的参数列表
***
-XX:ReservedCodeCacheSize=251658240 
***
-XX:+SegmentedCodeCache 
***
-XX:+UseCompressedClassPointers 
***
-XX:+UseCompressedOops 使用指针压缩（前提JVM内存不能超过32G,否则指针压缩会失效）
***
-XX:+UseG1GC 使用的垃圾收集器
***
-XX:+TraceClassUnloading 开启类卸载日志
***
* -Xms:初始堆大小
* -Xmx:最大堆大小
* -Xmn:新生代大小
* -XX:NewRatio:设置新生代和老年代的比值。如：为3，表示年轻代与老年代比值为1：3
* -XX:SurvivorRatio:新生代中Eden区与两个Survivor区的比值。注意Survivor区有两个。如：为3，表示Eden：Survivor=3：2，一个Survivor区占整个新生代的1/5  
* -XX:MaxTenuringThreshold:设置转入老年代的存活次数。如果是0，则直接跳过新生代进入老年代。默认值15次。
* -XX:PermSize、-XX:MaxPermSize:分别设置永久代最小大小与最大大小（Java8以前）
* -XX:MetaspaceSize、-XX:MaxMetaspaceSize:分别设置元空间最小大小与最大大小（Java8以后）
***
* -XX:+UseSerialGC:设置串行收集器
* -XX:+UseParallelGC:设置并行收集器
* -XX:+UseParalledlOldGC:设置并行老年代收集器
* -XX:+UseConcMarkSweepGC:设置并发收集器
***
* -XX:+PrintGC
* -XX:+PrintGCDetails
* -XX:+PrintGCTimeStamps
* -Xloggc:filename
***
* -XX:ParallelGCThreads=n:设置并行收集器收集时使用的CPU数。并行收集线程数。
* -XX:MaxGCPauseMillis=n:设置并行收集最大暂停时间
* -XX:GCTimeRatio=n:设置垃圾回收时间占程序运行时间的百分比。公式为1/(1+n)
***
* -XX:+CMSIncrementalMode:设置为增量模式。适用于单CPU情况。
* -XX:ParallelGCThreads=n:设置并发收集器新生代收集方式为并行收集时，使用的CPU数。并行收集线程数。
***
-Xss600k 线程栈的大小，经测试可以默认设置到600k差不多。一般栈的调用深度3000-5000依据来算的。
***