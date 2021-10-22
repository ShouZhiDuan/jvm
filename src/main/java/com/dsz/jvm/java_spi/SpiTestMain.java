package com.dsz.jvm.java_spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class SpiTestMain {
    public static void main(String[] args) {
        ServiceLoader<SpiTestService> loader = ServiceLoader.load(SpiTestService.class);
        Iterator<SpiTestService> iterator = loader.iterator();
        while (iterator.hasNext()){
            SpiTestService spiTestService = iterator.next();
            String msg = spiTestService.sayHello("HELLO SPI");
            System.out.println(msg);
        }
    }
}
