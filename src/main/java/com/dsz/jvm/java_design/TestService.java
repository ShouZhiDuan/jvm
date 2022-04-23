package com.dsz.jvm.java_design;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/4/22 22:39
 * @Description:
 */
public interface TestService {
    void test(Object o);
    default void testDO(){
        System.out.println("99999");
    }
}
