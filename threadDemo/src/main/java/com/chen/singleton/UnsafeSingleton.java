package com.chen.singleton;

import com.chen.common.TicketPool;
/**
 * 
 * @author haichen 
 * UnsafeSingleton
 * 线程不安全的单例
 *
 */
public class UnsafeSingleton {
	private static TicketPool instance = null;

	public static TicketPool getInstance() {
		if (instance == null) {
			instance = new TicketPool();
		}

		return instance;
	}
}
