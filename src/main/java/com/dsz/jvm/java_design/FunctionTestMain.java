package com.dsz.jvm.java_design;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/4/23 8:54
 * @Description:
 */
public class FunctionTestMain {
    public static void main(String[] args) {
        String txt = "a" + "b" + "c";
        FuncctionService service = (msg) -> System.out.println("666666");
        service.functionTest("88");
    }
}
