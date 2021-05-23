package com.example.exception;

public class ServiceException extends BaseException {

	/**  */
	private static final long serialVersionUID = 7110442114070635700L;

	public ServiceException(String errorCode, Object... args) {
		super(errorCode, args);
	}

	public ServiceException(String errorCode, String errorDesc) {
		super(errorCode, errorDesc);
	}

	public ServiceException(String errorCode, String errorDesc, Throwable t) {
		super(errorCode, errorDesc, t);
	}

	public ServiceException(String errorCode, Throwable t, Object... args) {
		super(errorCode, t, args);
	}
	
	public String getErrorDesc() {
		return super.getErrorDesc();
	}

}
