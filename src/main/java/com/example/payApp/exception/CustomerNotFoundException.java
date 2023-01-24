package com.example.payApp.exception;

public class CustomerNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CustomerNotFoundException() {
		super();
	}
	public CustomerNotFoundException(String msg) {
		super(msg);
	}
}
