package com.example.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler
	public ResponseEntity<ErrorInfo> generalExceptionHandler(HttpServerErrorException e) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorInfo> resourceAccessExceptionHandler(ResourceAccessException e) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorCode(HttpStatus.SERVICE_UNAVAILABLE.value());
		error.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.SERVICE_UNAVAILABLE);
	}

}
