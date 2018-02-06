package com.chen.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author haichen 
 * 线程集结
 *
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        final CyclicBarrier cb = new CyclicBarrier(5);
        ExecutorService service = Executors.newFixedThreadPool(5);
        try {
            for (int i = 0; i < 5; i++) {
                Runnable runnable = new Runnable() {

                    public void run() {
                        System.out.println(Thread.currentThread().getName() + ": thread waiting");
                        try {
                            cb.await();// 此处发生阻塞， 当5个线程都运行到此处时才能继续向下运行
                            System.out.println(Thread.currentThread().getName() + ": thread end");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    }
                };
                service.execute(runnable);

            }
        } finally {
            service.shutdown();
        }
    }

}
