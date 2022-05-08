package com.dsz.jvm.dynamic_proxy.jdk;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/5/7 11:48
 * @Description:
 */
public class JdkProxyTestMain {
    public static void main(String[] args) {
        JdkProxy<JdkProxyService> jdkProxy = new JdkProxy(new JdkProxyServiceImpl());
        JdkProxyService proxy = jdkProxy.getProxy();
        proxy.helloJdkProxy("test ...");
    }
}
