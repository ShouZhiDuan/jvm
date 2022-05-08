package com.dsz.jvm.dynamic_proxy.jdk.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/5/8 16:16
 * @Description:
 */
public class TestInvokeHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Im only service, But I can do something by myself！");
        return "Invoke OK";
    }

    public <T> T clientProxy(final Class<T> interfaceCls){
        return (T) Proxy.newProxyInstance(
                interfaceCls.getClassLoader(), //被代理类加载器
                new Class<?>[]{interfaceCls},  //被代理类接口
                this //实现类
        );
    }
}
