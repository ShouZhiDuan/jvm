# jvm
JVM学习系统知识
JKD官网https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-1.html#jvms-1.2

## 1、常用JVM操作命令
* 生成二进制文件 Test.class 
`javac -g:vars Test.java`
* 二进制反编译字节码
`javap -v -p Test.class` 


## 2、类文件描述
https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html


## 3、类加载[类的加载过程参考](https://tin.js.org/2021/02/14/openjdk-constant-pool/)
### 3.1 加载过程
* 加载
* 链接
* 执行

### 3.2 [类加载器](https://segmentfault.com/a/1190000037574626)



### 4、JVM常用参数
`-Xverify:none`  符号引用验证(类加载连接过程有个这个阶段)


### 5、项目只是体系
* 实现自定义类加载器 com.dsz.jvm.class_load
* 实现jvm热部署 com.dsz.jvm.class_load.hot_deploy
* 计算对象实例大小 com.dsz.jvm.class_space.TestMain
