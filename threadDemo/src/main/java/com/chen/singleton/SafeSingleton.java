package com.chen.singleton;

import com.chen.common.TicketPool;

/**
 * 
 * @author haichen 
 * SafeSingleton 
 * 线程安全的单例
 *
 */
public class SafeSingleton {
    private volatile TicketPool instance = null;

    public TicketPool getInstance() {
        if (instance == null) {//防止线程等待
            synchronized (this) {
                if (instance == null) {//进入同步代码块之后再次判断
                    instance = new TicketPool();
                }
            }
        }

        return instance;
    }
}
