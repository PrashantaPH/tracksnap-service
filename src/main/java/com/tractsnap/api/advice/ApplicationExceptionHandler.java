package com.tractsnap.api.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.tractsnap.api.dto.ResponseStructure;
import com.tractsnap.api.exception.ResourceNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResponseStructure<?>> handleInvalidData(ResourceNotFoundException exception) {
		ResponseStructure<?> responseStructure = new ResponseStructure<>();
		
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		
		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseStructure<?>> handleInternalServerErr(Exception exception, WebRequest request){
		ResponseStructure<?> responseStructure = new ResponseStructure<>();
		
		responseStructure.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		responseStructure.setMessage("An unexpected error occurred. Please try again later...!"+ exception.getMessage());
		
		return new ResponseEntity<>(responseStructure, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
