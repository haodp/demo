package com.demo.model;

public class BaseModel implements java.io.Serializable {

	/**
	 * 序列号码
	 */
	private static final long serialVersionUID = 1L;

	/** 是否成功 true:成功 false：失败 */
	private boolean success = true;

	/** 错误的场合，错误信息记录 */
	private String errorMessage;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
