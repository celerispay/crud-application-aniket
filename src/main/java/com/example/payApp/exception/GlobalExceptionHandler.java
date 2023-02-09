package com.example.payApp.exception;

import javax.batch.operations.JobRestartException;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@ResponseStatus
@Log4j2
public class GlobalExceptionHandler{
		
	/**
	 * Customer exception handler
	 * @param ex Exception
	 * @param request Request
	 * @return @ResponseEntity<ErrorMessage>
	 */
	
	@ExceptionHandler(CustomerNotFoundException.class)
		public ResponseEntity<ErrorMessage> handleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest request){
			ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
			log.info(errorMessage);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		}
	
	@ExceptionHandler(JobExecutionAlreadyRunningException.class)
	public ResponseEntity<org.springdoc.api.ErrorMessage> JobAlreadyRunningFoundException(JobExecutionAlreadyRunningException ex, WebRequest request){
		org.springdoc.api.ErrorMessage message = new org.springdoc.api.ErrorMessage("Job is Already Runnning");
		log.info(message);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
	}
	
	@ExceptionHandler(JobRestartException.class)
	public ResponseEntity<org.springdoc.api.ErrorMessage> JobRestartFoundException(JobRestartException ex, WebRequest request){
		org.springdoc.api.ErrorMessage message = new org.springdoc.api.ErrorMessage("Restart Found");
		log.info(message);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
	
	@ExceptionHandler(JobInstanceAlreadyCompleteException.class)
	public ResponseEntity<org.springdoc.api.ErrorMessage> JobInstanceAlreadyCompleteFoundException(JobInstanceAlreadyCompleteException ex , WebRequest request){
		org.springdoc.api.ErrorMessage message = new org.springdoc.api.ErrorMessage("Job instance already complete");
		log.info(message);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
	}
	
	@ExceptionHandler(JobParametersInvalidException.class)
	public ResponseEntity<org.springdoc.api.ErrorMessage> JobParametersInvalidFoundException(JobParametersInvalidException ex, WebRequest request){
		org.springdoc.api.ErrorMessage message = new org.springdoc.api.ErrorMessage("Job parameters are Invalid");
		log.info(message);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	}
}
