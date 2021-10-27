package com.dsz.jvm.smth_test;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class SmthingTest {
    public static void main(String[] args) {
        String a = "123";
        String b = "123";
        String c = String.valueOf(123);
        System.out.println(a == b);
        System.out.println(a == c);
    }
}
