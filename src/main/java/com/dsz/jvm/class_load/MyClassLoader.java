package com.dsz.jvm.class_load;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Auther: ShouZhi@Duan
 * @Description: 自定义类加载器
 * to see https://blog.csdn.net/weixin_33697898/article/details/92576006
 */
public class MyClassLoader extends ClassLoader {
    private final static Path DEFAULT_CLASS_DIR = Paths.get("E:", "classloader-test");

    private final Path classDir;

    public MyClassLoader() {
        super();
        this.classDir = DEFAULT_CLASS_DIR;

    }

    public MyClassLoader(String classDir) {
        super();
        this.classDir = Paths.get(classDir);
    }

    public MyClassLoader(String classDir, ClassLoader parent) {
        super(parent);
        this.classDir = Paths.get(classDir);
    }

    private byte[] readClassBytes(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");
        Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));
        if (!classFullPath.toFile().exists()) {
            throw new ClassNotFoundException("The Class " + name + " not  found");
        }
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Files.copy(classFullPath, baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new ClassNotFoundException("Load the class " + name + "  occur error.", e);
        }
    }

    @Override
    /*
     * (non-Javadoc)
     * @see java.lang.ClassLoader#findClass(java.lang.String)
     * 必须要重写这个类
     */
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = this.readClassBytes(name);
        if (null == classBytes || classBytes.length == 0) {
            throw new ClassNotFoundException("can not load the class ");
        }
        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    @Override
    public String toString() {
        return "My ClassLoader";
    }

    public void testInvoke() {
        System.out.println("invoke testInvoke method......");
    }

    public static void main(String[] args) {
        MyClassLoader classLoader = new MyClassLoader();
        Class<?> aClass = null;
        try {
            /**
             * E:/classloader-test/com/dsz/jvm/class_load
             */
            aClass = classLoader.loadClass("com.dsz.jvm.class_load.LoadTestObject");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获取当前的类加载器
        System.out.println("获取当前的类加载器 = " + aClass.getClassLoader());
        try {
            Object helloWorld = aClass.getConstructor().newInstance();
            System.out.println(helloWorld);
            System.out.println("类加载器：" + helloWorld.getClass().getClassLoader());
            Method welcomeMethod = aClass.getMethod("sayHello",String.class);
            String result = (String) welcomeMethod.invoke(helloWorld,"666666");
            System.out.println(result);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
