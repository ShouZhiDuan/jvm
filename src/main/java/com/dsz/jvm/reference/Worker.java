package com.dsz.jvm.reference;

import lombok.Data;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
@Data
public class Worker {
    private String name;
    private String addr;
    public Worker(String name, String addr){
        this.name = name;
        this.addr = addr;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("com.dsz.jvm.reference.Worker要被回收了");
    }
}
