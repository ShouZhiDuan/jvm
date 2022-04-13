package com.dsz.jvm.controller;

import com.dsz.jvm.dto.TestDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger loggerLg4j = LogManager.getLogger(TestController.class);
    private static final org.slf4j.Logger loggerSl4j = LoggerFactory.getLogger(TestController.class);


    public Object testRequest(){
        TestDTO dto = new TestDTO();
        return dto;
    }


    @GetMapping("/1")
    public void test(HttpServletRequest request, HttpServletResponse response){
        loggerSl4j.info("test{}",666);
        //Enumeration<String> attributeNames = request.getSession().getAttributeNames();
        Cookie cookie = new Cookie("name", "shouzhi");
        response.addCookie(cookie);
    }





}