package com.huaq.jichu.multithread;


/**
 * 通过线程通信，控制子线程与主线程交替执行
 */
public class ThreadCommunication {


    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 50; i++){
                    resource.sub(10);
                }
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 50; i++){
                    resource.main(100);
                }
            }
        }).start();
    }
}

class Resource{
    boolean inSubTurn = true;
    public synchronized void sub(int num){
        while (!inSubTurn){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i < num; i++){
            System.out.printf("sub: %s of loop %s.\n",i,num);
        }
        inSubTurn = false;
        notify();
    }

    public synchronized void main(int num){
        while (inSubTurn){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i < num; i++){
            System.out.printf("main: %s of loop %s.\n",i,num);
        }
        inSubTurn = true;
        notify();
    }
}
