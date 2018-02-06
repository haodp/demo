package com.chen.concurrent;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author haichen 
 * 可重入读写锁
 */
public class ReentrantReadWriteLockDemo {

    public static void main(String[] args) {
        final TicketPool pool = new TicketPool();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    pool.readTicket();
                }
            }).start();
            new Thread(new Runnable() {
                public void run() {
                    pool.putTicket(10);
                }
            }).start();
        }
    }

    static class TicketPool {
        Integer ticketNum = 0;
        ReadWriteLock rwLock = new ReentrantReadWriteLock();

        public void putTicket(int in) {

            rwLock.writeLock().lock();
            System.out.println("start put");
            try {
                ticketNum = ticketNum + in;
                try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println("end putTicket: ticketNum: " + ticketNum);
            } finally {
                System.out.println("end put");
                rwLock.writeLock().unlock();
            }
        }

        public int readTicket() {
            rwLock.readLock().lock();
            System.out.println("start read");
            System.out.println("readTicket: ticketNum: " + ticketNum);
            try {
            } finally {
                System.out.println("end read");
                rwLock.readLock().unlock();
            }
            return ticketNum;
        }

    }

}
