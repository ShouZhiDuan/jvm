package com.dsz.jvm.heap_size;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/5/6 14:45
 * @Description:
 */
public class HeapSizeTestMain {
    public static void main(String[] args) {
        while (true){
            //获取当前堆的大小 byte 单位
            long heapSize = Runtime.getRuntime().totalMemory();
            System.out.println("当前堆大小：" + heapSize);
            //获取堆的最大大小byte单位
            //超过将抛出 OutOfMemoryException
            long heapMaxSize = Runtime.getRuntime().maxMemory();
            System.out.println("最大堆大小：" + heapMaxSize);
            //获取当前空闲的内存容量byte单位
            long heapFreeSize = Runtime.getRuntime().freeMemory();
            System.out.println("当前空闲堆大小：" + heapFreeSize);
        }
    }
}
