package com.huaq.jichu.aop.responsibilitychain;

public abstract class Handler {

    protected Handler successor;

    public void process(){
        this.exec();
        if(successor != null){
            successor.process();
        }
    }

    protected abstract void exec();

    public void setSuccessor(Handler successor){
        this.successor = successor;
    }
}
