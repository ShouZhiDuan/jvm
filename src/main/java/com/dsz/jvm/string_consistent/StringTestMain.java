package com.dsz.jvm.string_consistent;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/6/27 20:00
 * @Description:
 */
public class StringTestMain {
    public static void main(String[] args) {
//        String a = "898989";
//        String b = new String("898989");
//        System.out.println(b == b.intern());
//        String str = new StringBuilder("8989").append("89").toString();
//        System.out.println(str.intern() == str);

        String s = new String("666666");
        String s2 = s.intern();
        System.out.println(s == s2);


    }

}
