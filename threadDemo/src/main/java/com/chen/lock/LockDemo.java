package com.chen.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author haichen 
 * 线程间通信 
 * 一共两个线程，第一个线程加一之后通知第二个线程，第二个线程减一之后通知第一个线程，第一个线程加一之后再通知第二个线程，如此反复
 */
public class LockDemo {

    public static void main(String[] args) {
        final SwitchService service = new SwitchService();
        new Thread(new Runnable() {

            public void run() {
                while (true) {
                    service.decrease();
                }

            }
        }).start();
        new Thread(new Runnable() {

            public void run() {
                while (true) {
                    service.increase();
                }
            }
        }).start();
    }

    private static class SwitchService {
        private Integer ticketNum = 0;// 初始值为0
        private volatile boolean isIncrease = false;// 默认为没有增加过
        private Object obj = new Object();// 对象锁
        // Lock rLock = new ReentrantLock();

        /**
         * 加一
         */
        public void increase() {
            synchronized (obj) {
                if (isIncrease) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ticketNum++;
                System.out.println("increase: " + ticketNum);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isIncrease = true;
                obj.notify();
            }
        }

        /**
         * 减一
         */
        public void decrease() {
            synchronized (obj) {
                if (!isIncrease) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ticketNum--;
                System.out.println("decrease: " + ticketNum);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isIncrease = false;
                obj.notify();

            }
        }
    }

}
