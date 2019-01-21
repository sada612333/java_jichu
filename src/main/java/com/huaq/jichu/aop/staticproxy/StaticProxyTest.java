package com.huaq.jichu.aop.staticproxy;

public class StaticProxyTest {

    public static void main(String[] args) {
        new StaticAgent(new Actor("Im a Actor")).speak();
    }
}
