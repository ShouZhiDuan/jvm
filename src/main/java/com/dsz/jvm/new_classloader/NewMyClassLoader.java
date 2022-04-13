package com.dsz.jvm.new_classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/4/13 17:22
 * @Description:
 */
public class NewMyClassLoader extends ClassLoader {

    private String filePath;

    public NewMyClassLoader(){}

    public NewMyClassLoader(String filePath){
        this.filePath = filePath;
    }

    public NewMyClassLoader(ClassLoader parent) {
        super(parent);
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException{
        File file = new File(filePath);
        try{
            byte[] bytes = getClassBytes(file);
            Class<?> c = this.defineClass(name, bytes, 0, bytes.length);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    private byte[] getClassBytes(File file) throws Exception{
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);
        while (true){
            int i = fc.read(by);
            if (i == 0 || i == -1)
                break;
            by.flip();
            wbc.write(by);
            by.clear();
        }
        fis.close();
        return baos.toByteArray();
    }


    /**
     * to see https://juejin.cn/post/6844903705171476493
     * 实现热加载 https://www.cnblogs.com/dxyoung/p/13753784.html
     */
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String filePath = "D:/People.class";
        NewMyClassLoader mcl = new NewMyClassLoader(filePath);
        Class<?> clazz = Class.forName("People", true, mcl);
        Object obj = clazz.newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());
    }
}
