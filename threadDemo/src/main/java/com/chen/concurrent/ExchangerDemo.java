package com.chen.concurrent;

import java.util.concurrent.Exchanger;

/**
 * @author haichen 
 * 线程间交换数据
 *
 */
public class ExchangerDemo {

    public static void main(String[] args) {
        final Exchanger<Integer> exchanger = new Exchanger<Integer>();
        new Thread(new Runnable() {

            public void run() {
                int data1 = 10;// data1
                try {
                    System.out.println("start to revceive data2");
                    int receiveData = exchanger.exchange(data1);// 阻塞等待交换数据
                    System.out.println("" + Thread.currentThread().getName() + ": data2 is :" + receiveData);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "thread-1").start();

        new Thread(new Runnable() {

            public void run() {
                int data2 = 20;// data2
                try {
                    System.out.println("start to revceive data1");
                    int receiveData = exchanger.exchange(data2);// 阻塞等待交换数据
                    System.out.println("" + Thread.currentThread().getName() + ": data1 is :" + receiveData);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "thread-2").start();

    }
}
