package com.lbl.concurrent.classloader.chapter5;

public class RuntimePackage {
    //RuntimePackage
    //com.wangwenjun.concurrent.classloader.chapter5
    //Boot.Ext.App.com.wangwenjun.concurrent.classloader.chapter5

    //Boot.Ext.App.SimpleClassLoaderTest
    //Boot.Ext.App.SimpleClassLoader.SimpleClassLoaderTest

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        SimpleClassLoader simpleClassLoader = new SimpleClassLoader();
        Class<?> aClass = simpleClassLoader.loadClass("com.lbl.concurrent.classloader.chapter5.SimpleObject");
        //sSystem.out.println(aClass.getClassLoader());
        SimpleObject simpleObject = (SimpleObject) aClass.newInstance();
    }
}
