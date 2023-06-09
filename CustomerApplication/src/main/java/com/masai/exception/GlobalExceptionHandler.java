package com.masai.exception;

import java.time.LocalDateTime;

import org.apache.catalina.startup.WebAnnotationSet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	ResponseEntity<MyErrorDetails> noHandlerException(NoHandlerFoundException nfe, WebRequest req) {

		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(nfe.getMessage());
		errorDetails.setDescription(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(CustomerException.class)
	ResponseEntity<MyErrorDetails> packageExceptionHandler(CustomerException pe, WebRequest req){
		
		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(pe.getMessage());
		errorDetails.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<MyErrorDetails> travelsExceptionHandler(MethodArgumentNotValidException me, WebRequest req){
		
		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(me.getMessage());
		errorDetails.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception pe, WebRequest req){
		
		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(pe.getMessage());
		errorDetails.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}

}
