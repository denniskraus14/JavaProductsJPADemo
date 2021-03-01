package com.cg.onlineshop.exceptions;

public class ProductServiceDownException extends Exception {

	public ProductServiceDownException() {
		super();
		
	}

	public ProductServiceDownException(String message, Throwable cause, boolean enableSuppression,boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ProductServiceDownException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ProductServiceDownException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ProductServiceDownException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
