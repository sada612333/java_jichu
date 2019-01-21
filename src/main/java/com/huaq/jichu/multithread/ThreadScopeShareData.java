package com.huaq.jichu.multithread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadScopeShareData {

    private static Map<String,Long> threadLocal = new HashMap<>();

    public static void main(String[] args) {
        new Thread(){};
        new Thread(new Runnable() {
            @Override
            public void run() {
                long data = new Random().nextLong();
                String threadName = Thread.currentThread().getName();
                System.out.printf("%s : %s\n",threadName,data);
                threadLocal.put(threadName,data);
                new A().get();
                new B().get();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                long data = new Random().nextLong();
                String threadName = Thread.currentThread().getName();
                System.out.printf("%s : %s\n",threadName,data);
                threadLocal.put(threadName,data);
                new A().get();
                new B().get();
            }
        }){
        }.start();
    }

    static class A{
        public void get(){
            String threadName = Thread.currentThread().getName();
            System.out.printf("A from %s get %s .\n",threadLocal.get(threadName),threadName);
        }
    }

    static class B{
        public void get(){
            String threadName = Thread.currentThread().getName();
            System.out.printf("B from %s get %s .\n",threadLocal.get(threadName),threadName);
        }
    }
}
