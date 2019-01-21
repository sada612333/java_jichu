package com.huaq.jichu.aop.staticproxy;

/**
 * 静态代理
 * 代理类与被代理类必须实现相同的接口
 * 代理类只能为接口服务
 */
public class StaticAgent implements Person{
    private Person person;

    public StaticAgent(Person person) {
        this.person = person;
    }

    public void speak(){
        System.out.println("before speak --- from " + this.getClass().getName());
        person.speak();
        System.out.println("after speak --- from " + this.getClass().getName());
    }
}
