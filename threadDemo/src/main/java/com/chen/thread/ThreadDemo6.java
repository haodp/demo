package com.chen.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import com.chen.common.TicketPool;
/**
 * 
 * @author haichen
 * 使用线程池优化购票
 */
public class ThreadDemo6 {

	@Test
	public void runDemo() {
		final TicketPool pool = new TicketPool();
/*		ExecutorService cachedThreadPoolsService = Executors.newCachedThreadPool();
		ExecutorService singleThreadservice  = Executors.newSingleThreadExecutor();*/
		//创建一个可重用固定线程数的线程池，可以控制线程的最大并发数
		ExecutorService fixedThreadPoolService = Executors.newFixedThreadPool(100);//最大并发数为100，相当于最多有100个人可以同时买票
		for (int i = 0; i < 1000; i++) {//创建100个线程
			Thread thread = new Thread(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + ": Ticket amount : " + pool.syncBlockByTicket());
				}
			});
			
			fixedThreadPoolService.execute(thread);
		}
		
		try {
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName() + ": Ticket amount : " + pool.getTicketNum());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
		    fixedThreadPoolService.shutdown();
        }
	}
}
