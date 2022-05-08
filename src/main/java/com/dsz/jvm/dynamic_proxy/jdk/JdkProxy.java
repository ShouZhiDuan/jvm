package com.dsz.jvm.dynamic_proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/5/7 11:31
 * @Description:
 */
public class JdkProxy<T> implements InvocationHandler {

    private Object target;

    public JdkProxy(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("===before call===");
        Object invoke = method.invoke(target, args);
        System.out.println(invoke.toString());
        System.out.println("===after call===");
        return invoke;
    }

    public T getProxy(){
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
