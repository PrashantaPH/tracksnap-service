package com.tractsnap.api.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseStructure<T> {

	private int status;

	private String message = "Success";

	private T data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public static <T> ResponseEntity<ResponseStructure<T>> ok(T data) {
		ResponseStructure<T> response = new ResponseStructure<>();
		response.setStatus(HttpStatus.OK.value());
		response.setData(data);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	public static <T> ResponseEntity<ResponseStructure<T>> created(T data) {
		ResponseStructure<T> response = new ResponseStructure<>();
		response.setStatus(HttpStatus.CREATED.value());
		response.setData(data);
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	public static <T> ResponseEntity<ResponseStructure<String>> accepted(T data) {
		ResponseStructure<String> response = new ResponseStructure<>();
		response.setStatus(HttpStatus.ACCEPTED.value());
		response.setData("Companies ID :" + data + " deleted successfully...!");
		
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}

}
