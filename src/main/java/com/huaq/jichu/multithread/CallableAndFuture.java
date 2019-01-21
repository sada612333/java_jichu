package com.huaq.jichu.multithread;


import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;

import java.util.Random;

public class CallableAndFuture {

    @Test
    public void executorServiceTest() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(5000);
                return "hello";
            }
        });
        System.out.println("等待结果...");
        System.out.println("结果："+future.get());
    }

    @Test
    public void completionServiceTest() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);
        for (int i = 1; i <= 10; i++){
            final int seq = i;
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));
                    return seq;
                }
            });
        }

        for (int i = 1; i <= 10; i++){
            System.out.println(completionService.take().get());
        }
        executorService.shutdown();
    }

}
