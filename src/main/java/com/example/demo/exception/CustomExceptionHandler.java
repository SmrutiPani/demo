package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler({Exception.class, RuntimeException.class})
	public ResponseEntity<ErrorMessage> handleRuntimeException(Exception ex) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(500);
		errorMessage.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorMessage,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
