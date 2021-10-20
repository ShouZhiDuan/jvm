package com.dsz.jvm.java_spi;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class SpiTestServiceImpl implements SpiTestService{
    @Override
    public String sayHello(String msg) {
        return msg;
    }
}
