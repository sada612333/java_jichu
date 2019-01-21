package com.huaq.jichu.aop.dynamicproxy;

public class Apple implements Fruit {
    @Override
    public void show() {
        System.out.println("this is apple. --- from " + this.getClass().getName());
    }
}
