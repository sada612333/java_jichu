package com.huaq.jichu.aop.responsibilitychain;

import java.util.ArrayList;

public class HandlerTest {

    public static void main(String[] args) {
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();
        Handler handlerC = new HandlerC();

        handlerA.setSuccessor(handlerB);
        handlerB.setSuccessor(handlerC);

        handlerA.process();
        ArrayList

    }

    static class HandlerA extends Handler{
        @Override
        protected void exec() {
            System.out.println("--- from " + this.getClass().getName());
        }
    }
    static class HandlerB extends Handler{
        @Override
        protected void exec() {
            System.out.println("--- from " + this.getClass().getName());
        }
    }
    static class HandlerC extends Handler{
        @Override
        protected void exec() {
            System.out.println("--- from " + this.getClass().getName());
        }
    }
}
