package com.dsz.jvm.new_jvm;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/4/13 14:25
 * @Description:
 */
public class JvmTest2 {

    private int intflagB = 10;
    private int intflag = 111111;
    private double aDoubleflag = 222222;
    private long aLongflag = 333333;
    private Integer integerflag = new Integer(89898989);
    private Integer integerflag2 = 89898989;
    private String str = new String("999999");
    private String str5 = "555555";

    void test() {
        String str2 = new String("101010101010");
        String str3 = "121212121212";
        String str6 = "a" + "b" + "c";
        System.out.println("666666");
        int a = 777;
        int b = 888;
    }

    public static void main(String[] args) {
        Float a = 2f;
        Float b = 2f;
        System.out.println(a == b);
    }

}
