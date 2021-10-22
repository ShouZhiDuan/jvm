package com.dsz.jvm.class_space;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class TestMain {
    public static void main(String[] args) {
        ClassSpaceTest spaceTest = new ClassSpaceTest();
        spaceTest.setaString("abc");
        System.out.println(ClassLayout.parseInstance(spaceTest).toPrintable());
    }
}
