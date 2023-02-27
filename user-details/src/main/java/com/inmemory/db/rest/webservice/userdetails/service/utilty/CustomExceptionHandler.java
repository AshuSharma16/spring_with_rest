package com.inmemory.db.rest.webservice.userdetails.service.utilty;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ExceptionDetails details = new ExceptionDetails();
		details.setErrorMesssage(ex.getMessage());
		details.setErrorDetails(request.getDescription(false));
		return new ResponseEntity<Object>(details, HttpStatus.NOT_FOUND);
	}

}
