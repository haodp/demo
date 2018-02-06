package com.chen.thread;

import org.junit.Test;

/**
 * @author haichen 
 * 使用匿名内部类快速创建线程
 */
public class ThreadDemo3 {

	Integer count = 3;

	@Test
	public void runDemo() {
		// for (int i = 0; i < 10; i++) {
		final int threadNum = 0;
		new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + ": threadNum: " + threadNum);
			}
		}).start();
		// }

		System.out.println(Thread.currentThread().getName() + ": count: " + count);
	}

}
