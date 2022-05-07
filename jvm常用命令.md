# 一、JVM工具

`Heap Dump分析工具`

- https://heaphero.io/

`GC log分析工具`

- https://gceasy.io/

# 二、JVM常用命令

## 1、java进程列表

```shell
jps -l
```

```shell
10464 com.dsz.jvm.JvmApplication
27024 org.jetbrains.jps.cmdline.Launcher
11240
22728 jdk.jcmd/sun.tools.jps.Jps
```

## 2、堆中对象和实例、空间大小

```shell
jmap -histo:live <进程ID>
```

```shell
 num     #instances         #bytes  class name (module)
-------------------------------------------------------
   1:         40575        3923544  [B (java.base@11.0.8)
   2:         38694         928656  java.lang.String (java.base@11.0.8)
   3:          6810         806416  java.lang.Class (java.base@11.0.8)
   4:          7668         674784  java.lang.reflect.Method (java.base@11.0.8)
   5:         17526         560832  java.util.concurrent.ConcurrentHashMap
   6:          8764         451944  [Ljava.lang.Object; (java.base@11.0.8)
```

## 3、堆空间分配查询

```shell
jhsdb jmap --heap --pid <进程ID>
```

```shell
Attaching to process ID 10464, please wait...
Debugger attached successfully.
Server compiler detected.
JVM version is 11.0.8+10-LTS

using thread-local object allocation.
Garbage-First (G1) GC with 8 thread(s)

Heap Configuration:
   MinHeapFreeRatio         = 40
   MaxHeapFreeRatio         = 70
   MaxHeapSize              = 4257218560 (4060.0MB)
   NewSize                  = 1363144 (1.2999954223632812MB)
   MaxNewSize               = 2554331136 (2436.0MB)
   OldSize                  = 5452592 (5.1999969482421875MB)
   NewRatio                 = 2
   SurvivorRatio            = 8
   MetaspaceSize            = 21807104 (20.796875MB)
   CompressedClassSpaceSize = 1073741824 (1024.0MB)
   MaxMetaspaceSize         = 17592186044415 MB
   G1HeapRegionSize         = 1048576 (1.0MB)

Heap Usage:
G1 Heap:
   regions  = 4060
   capacity = 4257218560 (4060.0MB)
   used     = 12161528 (11.598136901855469MB)
   free     = 4245057032 (4048.4018630981445MB)
   0.2856683965974253% used
G1 Young Generation:
Eden Space:
   regions  = 0
   capacity = 22020096 (21.0MB)
   used     = 0 (0.0MB)
   free     = 22020096 (21.0MB)
   0.0% used
Survivor Space:
   regions  = 0
   capacity = 0 (0.0MB)
   used     = 0 (0.0MB)
   free     = 0 (0.0MB)
   0.0% used
G1 Old Generation:
   regions  = 14
   capacity = 27262976 (26.0MB)
   used     = 12161528 (11.598136901855469MB)
   free     = 15101448 (14.401863098144531MB)
   44.60821885329027% used
```

## 4、堆dump输出

```shell
jmap -dump:format=b,file=D://heap.hprof <进程ID>
jmap -dump:live,format=b,file=heap.bin <pid>
```

```shell
-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=heap.hprof
```

## 5、输出gc.log

```shell
-Xlog:gc*:D:\gc.log
```

## 6、全局JVM参数

```shell
java -XX:+PrintFlagsFinal -version
```

## 7、常见参数操作

```shell
# 查看jvm运行参数
jinfo -flags pid
# 查看具体参数值
jinfo -flag InitialHeapSize pid
# 开启/关闭某个JVM参数
jinfo -flag [+|-]name pid
# 修改某个JVM进程的值
jinfo -flag name=value pid
# 输出当前JVM进程所有的系统属性
jinfo -sysprops pid
```

## 8、jar启动示例

```shell
springboot参数放在jar包之后
nohup java -jar jvm.jar --spring.profiles.active=prod > jvm.log 2>&1 &
```

```shell
jvm参数放在jar包之前
nohup java -jar -Xverify:none jvm.jar  > jvm.log 2>&1 & (参数-Xverify:none生效)
```

## 9、开启jmx监听

```shell
#多参数启动示例(后台启动模式)
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
-XX:+PrintFlagsFinal \
-XX:InitialHeapSize=4164069376 \
-XX:MaxHeapSize=4164069376 \
-Xss2m \
jvm.jar  > jvm.log 2>&1 & 

#多参数启动实例(监听启动模式)
java -jar \
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
-XX:+PrintFlagsFinal \
-XX:+PrintGCDetails \
jvm.jar
```

## 10、栈大小（默认1MB）

```shell
线程栈的大小，经测试可以默认设置到600k差不多。一般栈的调用深度3000-5000依据来算的。
-Xss600k (500-600)k
```

## 11、输出自定义设置的参数

```shell
-XX:+PrintCommandLineFlags
```

## 12、查看当前java进程虚拟机参数列表

```shell
* jps -v | grep (进程ID/jar名称)
* 工具Java VisualVN也可以查看
```

## 13、输出垃圾回收日志详情

```shell
-XX:+PrintGCDetails 
```

## 14、开启类卸载日志

```shell
-XX:+TraceClassUnloading
```

## 15、开启指针压缩

```shell
-XX:+UseCompressedOops 使用指针压缩（前提JVM内存不能超过32G,否则指针压缩会失效）
-XX:+UseCompressedClassPointers
```





