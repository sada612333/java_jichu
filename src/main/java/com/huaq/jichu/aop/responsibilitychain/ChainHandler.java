package com.huaq.jichu.aop.responsibilitychain;

abstract public class ChainHandler {

    public void process(Chain chain){
        this.exec();
        chain.process();
    }

    abstract protected void exec();
}
