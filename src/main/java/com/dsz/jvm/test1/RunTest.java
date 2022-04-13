package com.dsz.jvm.test1;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class RunTest {


    public static void main(String[] args) {
        new Thread(()->{
            try {
                while (true) {
                    Thread.sleep(1000);
                    System.err.println("测试线程");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
