package com.dsz.jvm.class_load.hot_deploy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: ShouZhi@Duan
 * @Description: 用于热部署类加载器
 */
public class HotDeploy {
//    private static volatile Runnable instance;
//    private final String FILE_NAME; //类的绝对路径
//    private final String CLASS_NAME; //类的权限定名
//
//    public HotDeploy(String name) {
//        CLASS_NAME = name; // 类的完全限定名
//        name = name.replaceAll("\\.", "/") + ".class";
//        //// 判断class文件修改时间使用，substring(6)去掉开头的(file:/)
//        //FILE_NAME = (this.getClass().getResource("/") + name).substring(6);
//        FILE_NAME = "E:/classloader-test/com/dsz/jvm/class_load/Task.class";
//        System.out.println("FILE_NAME = " + FILE_NAME);
//    }
//
//    /**
//     * 获取一个任务
//     * @return
//     */
//    public Runnable getTask() {
//        if (instance == null) { // 双重检查锁，单例，线程安全
//            synchronized (this) {
//                if (instance == null) {
//                    try {
//                        instance = createTask();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//        return instance;
//    }
//
//    /**
//     * 创建一个任务，重新加载 class 文件
//     */
//    private Runnable createTask() {
//        try {
//            Class<?> clazz = new HotDeployClassLoader(null).loadClass(CLASS_NAME);
//            System.out.println("类加载器 " + clazz.getClassLoader());
//            if (clazz != null)
//                return (Runnable)clazz.newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//    /**
//     * 监视器，监视class文件是否被修改过，如果是的话，则重新加载
//     */
//    public void monitor() {
//        Thread t = new Thread(()->{
//            try {
                  //注意这里的Path.of是jdk11中的，如果使用jdk8的话编译不能通过，所以这里注释。
//                long lastModified = Files.getLastModifiedTime(Path.of(FILE_NAME)).toMillis();
//                while(true) {
//                    TimeUnit.SECONDS.sleep(1);
//                    long now = Files.getLastModifiedTime(Path.of(FILE_NAME)).toMillis();
//                    if(now != lastModified) {
//                        System.out.println(FILE_NAME + "文件被修改");
//                        lastModified = now;
//                        instance = createTask();
//                    }
//                }
//            } catch (InterruptedException | IOException e) {
//                e.printStackTrace();
//            }
//        });
//        t.setDaemon(true); // 守护进程
//        t.start();
//    }
//
//
//    /**
//     * 自定义类加载器
//     */
//    private class HotDeployClassLoader extends ClassLoader {
//        private HotDeployClassLoader(ClassLoader parent) {
//            super(parent);
//        }
//        @Override
//        public Class<?> findClass(String name) throws ClassNotFoundException {
//            try {
//                byte[] b = Files.readAllBytes(Path.of(FILE_NAME));
//                return defineClass(name, b, 0, b.length);
//            } catch (IOException e) {
//                throw new ClassNotFoundException(name);
//            }
//        }
//    }
}
