package com.chen.thread;

import org.junit.Test;

import com.chen.common.TicketPool;
/**
 * @author haichen
 * 模拟买票逻辑
 */
public class ThreadDemo4 {

	@Test
	public void runDemo() {
		final TicketPool pool = new TicketPool();
		for (int i = 0; i < 1000; i++) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + ": Ticket amount : " + pool.byTicket());//未同步
					//System.out.println(Thread.currentThread().getName() + ": Ticket amount : " + pool.syncByTicket());//方法同步
					//System.out.println(Thread.currentThread().getName() + ": Ticket amount : " + pool.syncBlockByTicket());//同步代码块
				}
			});
			thread.start();
		}
		
		try {
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName() + ": final Ticket amount : " + pool.getTicketNum());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
