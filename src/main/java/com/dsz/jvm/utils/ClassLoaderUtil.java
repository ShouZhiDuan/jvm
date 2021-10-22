package com.dsz.jvm.utils;

import com.dsz.jvm.class_load.MyClassLoader;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class ClassLoaderUtil {

    /**
     * @param className  类全限定名(例如：com.test.String)
     * com.dsz.jvm.class_load.LoadTestObject
     */
    public static Class getLoadClass(String className) throws ClassNotFoundException {
        MyClassLoader classLoader = new MyClassLoader();
        Class<?> aClass = classLoader.loadClass(className);
        return aClass;
    }

}
