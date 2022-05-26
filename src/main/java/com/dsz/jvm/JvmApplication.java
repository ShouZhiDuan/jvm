package com.dsz.jvm;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;

@SpringBootApplication
public class JvmApplication {

//    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication(JvmApplication.class);
//        springApplication.setBannerMode(Banner.Mode.OFF);
//        springApplication.run(args);
//    }

    /**
     * 输出内存数据使用情况
     */
    public static void main(String[] args) {
        byte[] bytes = new byte[1024*1024*3];
        for (MemoryPoolMXBean memoryPoolMXBean : ManagementFactory.getMemoryPoolMXBeans()){
            System.out.println(memoryPoolMXBean.getName()
            + "  已使用：" + memoryPoolMXBean.getUsage().getUsed()/1024/1024 + "MB"
            + "  总大小：" + memoryPoolMXBean.getUsage().getCommitted()/1024/1024 + "MB");
        }
    }




}
