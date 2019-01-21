package com.huaq.jichu.multithread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用CountDownLatch控制多线程同步
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(3);
        CountDownLatch cdlOrder = new CountDownLatch(1);
        CountDownLatch cdlAnswer = new CountDownLatch(3);
        for(int i = 0; i < 3; i++){
            Runnable run = new Runnable(){
                @Override
                public void run() {
                    try {
                        String threadName = Thread.currentThread().getName();
                        System.out.printf("%s等待命令中...\n",threadName);
                        cdlOrder.await();

                        System.out.printf("%s正在执行命令...\n",threadName);
                        Thread.sleep(new Random().nextInt(5) * 1000);
                        cdlAnswer.countDown();

                        System.out.printf("%s结果已返回.\n",threadName);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            es.execute(run);
        }
        Thread.sleep(5000);
        System.out.printf("%s准备发布命令...\n",Thread.currentThread().getName());
        cdlOrder.countDown();

        System.out.printf("%s命令已发布，等待结果中...\n",Thread.currentThread().getName());
        cdlAnswer.await();
        System.out.printf("%s结果全部收到.\n",Thread.currentThread().getName());

        es.shutdown();
    }
}
