package com.chen.thread;

import org.junit.Test;

/**
 * 
 * @author haichen
 *实现Runnable接口
 */
public class ThreadDemo2 implements Runnable{

	Integer count = 2;
	
	/**
	 * 实现run方法
	 */
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": count: " + count);
	}
	@Test
	public void runDemo() {
		Runnable runnable = new ThreadDemo2();//Runnable需要借助thread启动，实际调用的是Runnable的run方法

		Thread thread = new Thread(runnable);
		thread.setName("ThreadDemo2");
		thread.start();
		//参照Thread源码如下
		/*  @Override
		    public void run() {
		        if (target != null) {
		            target.run();
		        }
		    }*/
		System.out.println(Thread.currentThread().getName() + ": count: " + count);

	}

}
