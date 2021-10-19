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
* -Xverify:none  符号引用验证(类加载连接过程有个这个阶段)
* -XX:+PrintGCDetails [全局参数] 打印垃圾回收日志 java -XX:+PrintGCDetails -version
* -XX:+PrintCommandLineFlags [全局参数]  java -XX:+PrintCommandLineFlags -version
开启启动jar输出jvm相关参数(堆大小设置、垃圾收集器等相关参数：
`-XX:-BytecodeVerificationLocal 
  -XX:-BytecodeVerificationRemote 
  -XX:G1ConcRefinementThreads=8 
  -XX:GCDrainStackTargetSize=64 
  -XX:+HeapDumpOnOutOfMemoryError 
  -XX:HeapDumpPath=/tmp/gc.hprof 
  -XX:InitialHeapSize=260254336 
  -XX:+ManagementServer 
  -XX:MaxHeapSize=4164069376 
  -XX:+PrintCommandLineFlags 
  -XX:ReservedCodeCacheSize=251658240 
  -XX:+SegmentedCodeCache 
  -XX:+UseCompressedClassPointers 
  -XX:+UseCompressedOops 
  -XX:+UseG1GC
 `
)
