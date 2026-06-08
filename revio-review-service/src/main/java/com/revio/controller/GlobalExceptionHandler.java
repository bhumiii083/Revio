package com.revio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.revio.exception.ReviewNotFoundException;
import com.revio.exception.SubmissionNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(SubmissionNotFoundException.class)
	public ResponseEntity<String> handleSubmissionNotFound(SubmissionNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ReviewNotFoundException.class)
	public ResponseEntity<String> handleReviewNotFound(ReviewNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage() , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
