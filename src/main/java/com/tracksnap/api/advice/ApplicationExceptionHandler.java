package com.tracksnap.api.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.tracksnap.api.dto.ResponseStructure;
import com.tracksnap.api.exception.ResourceNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseStructure<Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ResponseStructure<Map<String, String>> responseStructure = new ResponseStructure<>();
		Map<String, String> errorMap = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
			errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
		});
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage("Failure");
		responseStructure.setData(errorMap);
		return new ResponseEntity<>(responseStructure, HttpStatus.BAD_REQUEST);
    }

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
		responseStructure.setMessage("An unexpected error occurred. "+ exception.getMessage());
		
		return new ResponseEntity<>(responseStructure, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
