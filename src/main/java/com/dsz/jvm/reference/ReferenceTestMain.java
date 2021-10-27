package com.dsz.jvm.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class ReferenceTestMain {
    public static void main(String[] args) {
        //软引用测试
        testSoft();
        //弱引用
        //testWeak();
    }

    public static void testSoft(){
        Worker worker = new Worker("名字","地址");
        SoftReference ref = new SoftReference(worker);
        worker = null;
        if(ref != null){
            worker = (Worker) ref.get();
        }else {
            worker = new Worker("名字","地址");
            ref = new SoftReference(worker);
            worker = null;
        }
    }

    public static void  testWeak() throws InterruptedException {
        //100M的缓存数据
        byte[] cacheData = new byte[100 * 1024 * 1024];
        // 将缓存数据用软引用持有
        WeakReference<byte[]> cacheRef = new WeakReference<>(cacheData);
        System.out.println("第一次GC前" + cacheData);
        System.out.println("第一次GC前" + cacheRef.get());
        //进行一次GC后查看对象的回收情况
        System.gc();
        // 等待GC
        Thread.sleep(1000);
        System.out.println("第一次GC后" + cacheData);
        System.out.println("第一次GC后" + cacheRef.get());
        //将缓存数据的强引用去除
        cacheData = null;
        System.gc();
        //等待GC
        Thread.sleep(1000);
        System.out.println("第二次GC后" + cacheData);
        System.out.println("第二次GC后" + cacheRef.get());
        Thread.sleep(3600*1000);
    }
}
