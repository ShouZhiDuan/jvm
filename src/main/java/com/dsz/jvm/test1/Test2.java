package com.dsz.jvm.test1;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class Test2 {

    private final static  String name = "my name";

    private final static  Test2 test2 = new Test2();

    private static int i = 666;

    static {
        i = 33;
    }

    private String msg = "msg666";

    //private static Test staticObj = new Test("name",8);

    private static String staticMsg = "staticMsg666";


//
//    public Test2(int i){
//        this.i = i;
//    }

    public static void main(String[] args) {
        System.out.println(i);
    }

}
