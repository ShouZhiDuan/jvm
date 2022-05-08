package com.dsz.jvm.dynamic_proxy.jdk.handler;

import com.dsz.jvm.dynamic_proxy.jdk.JdkProxyService;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/5/8 16:19
 * @Description:
 */
public class HandlerTestMain {
    public static void main(String[] args) {
        TestInvokeHandler testHandler = new TestInvokeHandler();
        JdkProxyService jdkProxyService = testHandler.clientProxy(JdkProxyService.class);
        jdkProxyService.helloJdkProxy("test 。。。");
    }
}
