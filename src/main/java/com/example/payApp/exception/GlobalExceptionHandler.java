package com.example.payApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
		
	/**
	 * Customer exception handler
	 * @param ex Exception
	 * @param request Request
	 * @return @ResponseEntity<ErrorMessage>
	 */
	@ExceptionHandler(CustomerNotFoundException.class)
		public ResponseEntity<ErrorMessage> handleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest request){
			ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		}
}
