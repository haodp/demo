package com.chen.thread;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

/**
 * 
 * @author haichen 
 * 使用java并发包java.util.concurrent.atomic.AtomicInteger  （读->运算->写）原子操作
 */
public class ThreadDemo5 {
	AtomicInteger ticketNum = new AtomicInteger(1000);

	@Test
	public void runDemo() {
		for (int i = 0; i < 1000; i++) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + ": Ticket amount : " + ticketNum.decrementAndGet());
				}
			});
			thread.start();
		}

		try {
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName() + ": Ticket amount : " + ticketNum.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
