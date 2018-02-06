package com.demo.common.exception;

import com.demo.common.constants.FwConstants;

public class ApplicationException extends Exception implements FwException {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private String messageId;

	private Object[] params;

	public ApplicationException(String messageId, Object... params) {
		this.messageId = messageId;
		this.params = params;
	}

	public ApplicationException(Throwable cause, String messageId, Object... params) {
		super(cause);
		this.messageId = messageId;
		this.params = params;
	}

	public Throwable getRealCause() {
		return super.getCause();
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	public int getReturnCode() {
		return FwConstants.FAILURE_APP;
	}

}
