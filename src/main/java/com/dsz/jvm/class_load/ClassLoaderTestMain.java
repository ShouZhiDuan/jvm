package com.dsz.jvm.class_load;

import com.dsz.jvm.test1.Test2;

/**
 * @Auther: ShouZhi@Duan
 * @Description: https://segmentfault.com/a/1190000037574626
 */
public class ClassLoaderTestMain {
    public static void main(String[] args) {
        String str = new String();
        System.out.println(str.getClass().getClassLoader());

        Test2 test = new Test2();
        System.out.println(test.getClass().getClassLoader());
        System.out.println(test.getClass().getClassLoader().getParent());

        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
