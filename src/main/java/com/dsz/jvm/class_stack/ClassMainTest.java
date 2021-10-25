package com.dsz.jvm.class_stack;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/10/25 10:09
 * @Description:
 */
public class ClassMainTest {

    private static long count = 1;

    public static void main(String[] args) {
        while (true){
             testStackTrace(count);
        }

    }

    public static void testStackTrace(long count){
        System.out.println(count++);
        testStackTrace(count);
    }
}
