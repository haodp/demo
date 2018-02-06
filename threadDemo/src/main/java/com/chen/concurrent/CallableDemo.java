package com.chen.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * @author haichen 
 * Callable 取得线程执行之后的结果
 *
 */
public class CallableDemo {

	public static void main(String[] args) {
		ExecutorService fixService = Executors.newFixedThreadPool(100);
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(fixService);//分离已完成的任务和未完成的任务，使完成的任务能够及时处理
		for (int i = 0; i < 100; i++){
			final int count = i;
			 completionService.submit(new Callable<Integer>() {
				
				public Integer call() throws Exception {
					return count;
				}
			});
			
		}
		Integer takeResult = null;
		try {
		while (true){
		 Future<Integer> takeFuture = completionService.take();//取得第一个执行完线程的结果,该结果是不确定的
		 takeResult = takeFuture.get();//future.get返回值为线程执行完后的结果, get时会发生阻塞,直到有线程返回结果
		 System.out.println(takeResult);
         }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		    fixService.shutdown();
        }
	}

}
