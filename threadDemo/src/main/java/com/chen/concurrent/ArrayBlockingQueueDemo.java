package com.chen.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author haichen
 * 阻塞队列
 */
public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        final ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(3);
        ExecutorService putService = Executors.newFixedThreadPool(10);
        ExecutorService takeService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": start put");
                        blockingQueue.put(2);
                        System.out.println(
                            Thread.currentThread().getName() + ": end put queue size: " + blockingQueue.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            putService.execute(runnable);
        }

        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": start take");
                        blockingQueue.take();
                        System.out.println(
                            Thread.currentThread().getName() + ": end take queue size: " + blockingQueue.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            takeService.execute(runnable);
        }
    }
}
