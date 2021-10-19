package com.dsz.jvm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ShouZhi@Duan
 * @Description: JVM测试用
 */
@RestController
@RequestMapping("/jvm")
public class JvmTestController {

    @GetMapping("/test1")
    public Object test(String msg){
        return "OK" + msg;
    }

}
