package com.dsz.jvm.test1;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class Test {

    private String name = "This My Name!!!!!!";

    private Integer count = 999;

    public Test(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
