package com.dsz.jvm;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JvmApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(JvmApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
//        List list = new ArrayList();
//        while (true){
//            list.add(new byte[20]);
//            System.out.println("add bytes success");
//        }
    }

}
