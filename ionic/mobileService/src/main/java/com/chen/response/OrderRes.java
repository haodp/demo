package com.chen.response;

public class OrderRes extends BaseRes{
	private String orderNo;
	private String orderPic;
	private String orderName;
	private String orderAddr;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderPic() {
		return orderPic;
	}
	public void setOrderPic(String orderPic) {
		this.orderPic = orderPic;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderAddr() {
		return orderAddr;
	}
	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}
}
