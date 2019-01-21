package com.huaq.jichu.multithread;

/**
 * 使用wait、notify实现线程的交替执行
 */
public class WaitAndNotifyTest {

    public static void main(String[] args) throws InterruptedException {
        new WaitAndNotifyTest().test();
    }

    public void test() throws InterruptedException {
        String str = "";
        Thread child = new Thread(){
            @Override
            public void run() {
                while(true){
                    synchronized (str){
                        for (int i = 0; i < 10; i++){
                            System.out.printf("%s \t",i);
                        }
                        System.out.println(Thread.currentThread().getName()+"------");
                        try {
                            str.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        str.notify();
                    }
                }
            }
        };
        child.start();
        Thread.currentThread().sleep(500);
        while(true){
            synchronized (str){
                for (int i = 0; i < 20; i++){
                    System.out.printf("%s \t",i);
                }
                System.out.println(Thread.currentThread().getName()+"------");
                str.notify();
                str.wait();
            }
        }
    }
}
