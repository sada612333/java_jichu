package com.huaq.jichu.aop.staticproxy;

public class Actor implements Person{
    private String content;
    public Actor(String content){
        this.content = content;
    }

    public void speak(){
        System.out.println(content + "--- from " + this.getClass().getName());
    }
}
