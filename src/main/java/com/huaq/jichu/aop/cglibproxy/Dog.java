package com.huaq.jichu.aop.cglibproxy;

public class Dog {

    public void yell(){
        System.out.println("wang wang wang ~ ---- form " + this.getClass().getName());
    }

    public static void say(){
        System.out.println("dog can't say!!! ~ ---- form " + Dog.class.getName());
    }

    static class DogSon{
        void say(){
            System.out.println("wang wang wang ~ ---- form " + this.getClass().getName());
        }
    }
}
