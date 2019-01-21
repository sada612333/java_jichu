package com.huaq.jichu.aop.responsibilitychain;

import java.util.List;

public class Chain {
    private List<ChainHandler> list;
    private int index = 0;

    public Chain(List<ChainHandler> list) {
        this.list = list;
    }

    public void process(){
        if(index >= list.size()){
            return;
        }
        list.get(index++).process(this);
    }
}
