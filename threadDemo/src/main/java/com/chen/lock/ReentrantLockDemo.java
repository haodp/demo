package com.chen.lock;

import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class ReentrantLockDemo {

	@Test
	public void runDemo() {
		TicketPool pool = new TicketPool();
		pool.printTicket1();

	}
	
	

	class TicketPool {
		Integer ticketNum = 100;
		ReentrantLock rl = new ReentrantLock();

		synchronized public void  printTicket1() {
			//rl.lock();
			System.out.println(Thread.currentThread().getName() + ":printTicket1 " + ticketNum);
			printTicket2();
			//rl.unlock();
		}

		synchronized public void printTicket2() {
			//rl.lock();
			System.out.println(Thread.currentThread().getName() + ":printTicket2 " + ticketNum);
			//rl.unlock();
		}

	}

}
