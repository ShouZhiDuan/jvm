package com.dsz.jvm.dynamic_proxy.jdk;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/5/7 11:25
 * @Description:
 */
public class JdkProxyServiceImpl implements JdkProxyService{
    @Override
    public Object helloJdkProxy(String msg) {
        return msg;
    }
}
