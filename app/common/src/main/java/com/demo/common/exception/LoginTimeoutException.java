package com.demo.common.exception;

public class LoginTimeoutException extends ApplicationException implements FwException{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	public LoginTimeoutException() {
		super("fw.e.loginTimeout");
	}

}
