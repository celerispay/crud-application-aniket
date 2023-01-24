package com.example.payApp.exception;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
	private HttpStatus httpStatus;
	private String messageString;
	
	public ErrorMessage() {
		
	}
	
	
	public ErrorMessage(HttpStatus httpStatus, String messageString) {
		super();
		this.httpStatus = httpStatus;
		this.messageString = messageString;
	}
	

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMessageString() {
		return messageString;
	}
	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}
	
	
}
