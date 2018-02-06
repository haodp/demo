package com.chen.thread;

import org.junit.Test;

/**
 * 
 * @author haichen 
 * 继承Thread
 * 由于java是单继承所以此方法有局限
 *
 */
public class ThreadDemo1 extends Thread {

	Integer count = 1;
	
	/**
	 * 覆写run方法
	 */
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": count: " + count);
	}

	@Test
	public void runDemo() {
		Thread thread = new ThreadDemo1();
		thread.setName("ThreadDemo1");
		thread.start();
		System.out.println(Thread.currentThread().getName() + ": count: " + count);

	}

}
