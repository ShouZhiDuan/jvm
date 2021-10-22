package com.dsz.jvm.controller;

import com.dsz.jvm.utils.ClassLoaderUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: ShouZhi@Duan
 * @Description: 测试自定义类加载热部署
 */
@RestController
@RequestMapping("/jvm")
public class ClassLoaderController {

    private static Class clazz;

    /**
     * 执行热部署
     * http://localhost:8180/jvm/load_class
     */
    @GetMapping("/load_class")
      public Object loadClass(String msg, String className) throws ClassNotFoundException {
        if(StringUtils.isBlank(className)){
             className = "com.dsz.jvm.class_load.LoadTestObject";
        }
        clazz = ClassLoaderUtil.getLoadClass(className);
        return "OK";
      }


    /**
     * 验证热部署
     * http://localhost:8180/jvm/result?msg=666666
     */
    @GetMapping("/result")
    public Object result(String msg) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object instance = clazz.getConstructor().newInstance();
        System.out.println(instance);
        System.out.println("类加载器：" + instance.getClass().getClassLoader());
        Method welcomeMethod = clazz.getMethod("sayHello",String.class);
        String result = (String) welcomeMethod.invoke(instance,msg);
        System.out.println(result);
        return result;
    }



}
