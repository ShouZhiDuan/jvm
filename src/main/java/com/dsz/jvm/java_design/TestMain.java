package com.dsz.jvm.java_design;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/4/23 8:42
 * @Description:
 */
public class TestMain {
    public static void main(String[] args) {
       TestService testService = new TestService() {
           @Override
           public void test(Object o) {

           }
       };
       testService.testDO();
    }
}
