package com.dsz.jvm.new_jvm;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/4/13 14:25
 * @Description:
 */
public class JvmTest {

    private Integer age;
    private String name = "Jack";
    private Double salary = 100.0;
    private Object testObject  = new Object();
    private static String addressStatic = "test static address";
    private final String addressFnial = "test final static address";

    public void say() {
        System.out.println("Test Say...");
    }

    public static Integer calc(Integer op1, Integer op2) {
        op1 = 3;
        Integer result = op1 + op2;
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(calc(1, 2));
        Float v1 = 16f;
        Double v2 = new Double(300.0);
        Float v3 = 16f;
        System.out.println(v1 == v3);
    }

}
