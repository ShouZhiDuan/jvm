package com.dsz.jvm;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JvmApplication {

    public static void main(String[] args) {
        //ConfigurableApplicationContext run = SpringApplication.run(JvmApplication.class, args);
        SpringApplication springApplication = new SpringApplication(JvmApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

}
