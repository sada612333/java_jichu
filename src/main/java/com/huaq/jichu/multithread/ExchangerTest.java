package com.huaq.jichu.multithread;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * 使用Exchanger,控制线程的数据交换
 */
public class ExchangerTest {

    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger();
        new Thread(){
            @Override
            public void run() {
                try {
                    String threadName = Thread.currentThread().getName();
                    String oldName = "毒品";
                    Thread.sleep(new Random().nextInt(10) * 1000);
                    System.out.printf("%s已到达交易地点,正准备交换%s.\n",threadName,oldName);
                    String newName = exchanger.exchange(oldName);
                    System.out.printf("%s已获得%s.\n",threadName,newName);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    String threadName = Thread.currentThread().getName();
                    String oldName = "美元";
                    Thread.sleep(new Random().nextInt(10) * 1000);
                    System.out.printf("%s已到达交易地点,正准备交换%s.\n",threadName,oldName);
                    String newName = exchanger.exchange(oldName);
                    System.out.printf("%s已获得%s.\n",threadName,newName);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
