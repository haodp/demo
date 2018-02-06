package com.demo.common.exception;

public interface FwException {

	public Throwable getRealCause();

	public String getMessage();

	public String getMessageId();

	public void setMessageId(String messageId);

	public Object[] getParams();

	public void setParams(Object[] params);

	public int getReturnCode();

}
