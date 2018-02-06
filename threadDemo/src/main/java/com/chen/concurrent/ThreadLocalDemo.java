package com.chen.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author haichen 
 * ThreadLocal
 */
public class ThreadLocalDemo {

	private static ThreadLocal<Integer> local = new ThreadLocal<Integer>(){  
        @Override  
        protected Integer initialValue() {
            return 100;
            }
    };
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();	
		service.execute(new Runnable() {
			
			public void run() {
			    System.out.println(Thread.currentThread().getName()+" local: "+local.get());
				local.set(1);
				System.out.println(Thread.currentThread().getName()+" local: "+local.get());
				
			}
		});
		
		service.execute(new Runnable() {
			
			public void run() {
				System.out.println(Thread.currentThread().getName()+" local: "+local.get());
				local.set(2);
			    System.out.println(Thread.currentThread().getName()+" local: "+local.get());
				
			}
		});
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
		    service.shutdown();
		}
		
		  System.out.println(Thread.currentThread().getName()+"local: "+local.get());
	}

}
