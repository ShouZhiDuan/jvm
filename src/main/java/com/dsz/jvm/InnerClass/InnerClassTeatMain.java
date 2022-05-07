package com.dsz.jvm.InnerClass;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/4/25 13:07
 * @Description:
 */
public class InnerClassTeatMain {

    class Test1{
        String test1;
    }
    static class Test2{
        String test2;
    }

    void test(){
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
    }

}
