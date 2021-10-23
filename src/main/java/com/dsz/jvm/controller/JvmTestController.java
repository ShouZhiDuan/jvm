package com.dsz.jvm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Description: JVM测试用
 */
@RestController
@RequestMapping("/jvm")
public class JvmTestController {

    @GetMapping("/test1")
    public Object test(String msg){
        while (true){
            byte[] bytes = new byte[100];
        }
        //return "OK" + msg;
    }

    private static   List list = new ArrayList();
    /**
     * 测试模拟堆内存溢出
     */
    @GetMapping("/test2")
    public Object heap(){
        while (true){
            list.add(new byte[1000]);
        }
    }

}
