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
        spaceTest.setcInt(6666);
        System.out.println(ClassLayout.parseInstance(spaceTest).toPrintable());
        System.out.println("哈希码：" + spaceTest.hashCode());
    }
}
