package com.huaq.jichu.multithread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 使用CyclicBarrier控制多线程同步
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3);
        for (int i = 0; i < 3; i++){
            new Thread(){
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    try {
                        sleep(new Random().nextInt(10) * 1000);
                        System.out.printf("%s即将到达同步点1，当前已有%s个线程正在等候，%s...\n",threadName,cb.getNumberWaiting() + 1,
                                cb.getNumberWaiting() == 2 ? "均已到齐，前往下个同步点" : "继续等待");
                        cb.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    try {
                        sleep(new Random().nextInt(10) * 1000);
                        System.out.printf("%s即将到达同步点2，当前已有%s个线程正在等候，%s\n",threadName,cb.getNumberWaiting() + 1,
                                cb.getNumberWaiting() == 2 ? "均已到齐，前往下个同步点" : "继续等待");
                        cb.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    try {
                        sleep(new Random().nextInt(10) * 1000);
                        System.out.printf("%s即将到达同步点3，当前已有%s个线程正在等候，%s\n",threadName,cb.getNumberWaiting() + 1,
                                cb.getNumberWaiting() == 2 ? "均已到齐，结束" : "继续等待");
                        cb.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
