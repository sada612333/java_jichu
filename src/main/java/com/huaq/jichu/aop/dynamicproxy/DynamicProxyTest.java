package com.huaq.jichu.aop.dynamicproxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Fruit fruit = (Fruit) Proxy.newProxyInstance(DynamicProxyTest.class.getClassLoader(),
                new Class[]{Fruit.class},
                new DynamicAgent(new Apple()));
        fruit.show();
    }
    static class A{

    }

}
