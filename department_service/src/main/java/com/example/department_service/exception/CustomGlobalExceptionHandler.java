package com.example.department_service.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		CustomErrorDetails customErrorDetails = new CustomErrorDetails();
		customErrorDetails.setTimestamp(new Date());
		customErrorDetails.setMessage("validation failed");
		customErrorDetails.setErrorDetails(ex.getBindingResult().toString());
		
		return new ResponseEntity<>(customErrorDetails , HttpStatus.BAD_REQUEST);
	}
	
}
