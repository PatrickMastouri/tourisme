package com.soa.tourism.exception;

import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, 
			WebRequest request) {

		ErrorDetails desc = new ErrorDetails(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(desc, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RessourceDuplicated.class)
	public ResponseEntity<?> ressourceDuplicated( RessourceDuplicated ex,
												  WebRequest request){
		/* votre description de l'exception déclanchée */
		ErrorDetails desc = new ErrorDetails(new Date(), ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<>(desc,HttpStatus.FOUND);
		
	}


	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, 
			WebRequest request) {

		ErrorDetails desc = new ErrorDetails(new Date(),
				"Service Indisponible", request.getDescription(false));
		
		return new ResponseEntity<>(desc, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
