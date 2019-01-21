package com.huaq.jichu.aop.responsibilitychain;

import java.util.Arrays;
import java.util.List;

public class ChainHandlerTest {
    public static void main(String[] args) {
        List<ChainHandler> chainHandlers = Arrays.asList(new ChainHandlerA(),new ChainHandlerB(),new ChainHandlerC());
        Chain chain = new Chain(chainHandlers);
        chain.process();
    }

    static class ChainHandlerA extends ChainHandler{
        @Override
        protected void exec() {
            System.out.println("--- from " + this.getClass().getName());
        }
    }
    static class ChainHandlerB extends ChainHandler{
        @Override
        protected void exec() {
            System.out.println("--- from " + this.getClass().getName());
        }
    }
    static class ChainHandlerC extends ChainHandler{
        @Override
        protected void exec() {
            System.out.println("--- from " + this.getClass().getName());
        }
    }
}
