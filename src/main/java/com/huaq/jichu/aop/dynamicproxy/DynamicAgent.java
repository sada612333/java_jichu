package com.huaq.jichu.aop.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 * 代理类必须实现InvocationHandler的invoke方法
 * 然后使用Proxy.newProxyInstance(被代理类接口,被代理类)方法，返回一个包装过的对象
 * 可以为任意类对象生成代理类，但是被代理类必须要实现接口
 */
public class DynamicAgent implements InvocationHandler {

    private Object obj;
    public DynamicAgent(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke --- from " + this.getClass().getName());
        Object ret = method.invoke(this.obj,args);
        System.out.println("after invoke --- from " + this.getClass().getName());
        return ret;
    }
}
