package com.huaq.jichu.aop.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib生成一个模板，可以为任意类对象生成代理类
 * 被代理的类不必实现接口
 */
public class CglibAgent implements MethodInterceptor {

    private Object proxy;
    public Object getInstance(Object proxy){
        this.proxy = proxy;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.proxy.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("<!-----------------------");
        System.out.println("before invoke --- from " + Thread.currentThread().getName());
        Object ret = methodProxy.invokeSuper(o,objects);
        System.out.println("after invoke --- from " + Thread.currentThread().getName());
        System.out.println("-----------------------!>");
        return ret;
    }

    public static void main(String[] args) {
        CglibAgent agent = new CglibAgent();
        Dog dog = (Dog) agent.getInstance(new Dog());
        dog.yell();
        Dog.say();
        Dog.DogSon dogSon = (Dog.DogSon) agent.getInstance(new Dog.DogSon());
        dogSon.say();
    }
}
