package com.huaq.jichu.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过condition线程通信，实现3个线程交替执行
 */
public class ConditionCommunication {


    public static void main(String[] args) {
        Business business = new Business();
        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 50; i++){
                    business.sub1(10);
                }
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 50; i++){
                    business.sub2(20);
                }
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 50; i++){
                    business.sub3(30);
                }
            }
        }).start();
    }
}

class Business{
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    private int inSubTurn = 1;

    public void sub1(int num){
        lock.lock();
        try {
            while (inSubTurn != 1){
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int i = 1; i <= num; i++){
                System.out.printf("sub1: %s of loop %s.\n",i,num);
            }
            inSubTurn = 2;
            condition2.signal();
        }finally {
            lock.unlock();
        }
    }

    public void sub2(int num){
        lock.lock();
        try {
            while (inSubTurn != 2) {
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 1; i <= num; i++) {
                System.out.printf("sub2: %s of loop %s.\n", i, num);
            }
            inSubTurn = 3;
            condition3.signal();
        }finally {
            lock.unlock();
        }
    }

    public void sub3(int num){
        lock.lock();
        try {
            while (inSubTurn != 3) {
                try {
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 1; i <= num; i++) {
                System.out.printf("sub3: %s of loop %s.\n", i, num);
            }
            inSubTurn = 1;
            condition1.signal();
        }finally {
            lock.unlock();
        }
    }
}
