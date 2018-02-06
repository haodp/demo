package com.chen.common;

/**
 * 
 * @author haichen 
 * 票池类
 *
 */
public class TicketPool {
	private Integer ticketNum = 1000;// 初始票数

	/**
	 * 购买车票并返回剩余票数
	 * 
	 * @return
	 */
	public int byTicket() {
		ticketNum = ticketNum - 1;
		return ticketNum;
	}

	/**
	 * 整个方法同步
	 * （读->运算->写）原子操作
	 * @return
	 */
	public synchronized int syncByTicket() {
		ticketNum = ticketNum - 1;
		return ticketNum;
	}

	/**
	 * 同步代码块,避免过度同步
	 * （读->运算->写）原子操作
	 * @return
	 */
	public int syncBlockByTicket() {
		synchronized (this) {
		ticketNum = ticketNum - 1;
		}
		return ticketNum;
	}

	public Integer getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(Integer ticketNum) {
		this.ticketNum = ticketNum;
	}

}
