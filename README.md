# jvm
JVM学习系统知识
JKD官网https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-1.html#jvms-1.2

## 1、常用JVM操作命令
* 生成二进制文件 Test.class 
javac -g:vars Test.java
* 二进制反编译字节码
javap -v -p Test.class 


## 2、类文件描述
https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html


## 3、[类的加载过程参考](https://tin.js.org/2021/02/14/openjdk-constant-pool/)
* 加载
* 链接
* 执行