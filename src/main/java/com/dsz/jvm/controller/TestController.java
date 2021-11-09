package com.dsz.jvm.controller;

import com.dsz.jvm.dto.TestDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    public Object testRequest(){
        TestDTO dto = new TestDTO();
        return dto;
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replaceAll("\\-",""));
    }

}
