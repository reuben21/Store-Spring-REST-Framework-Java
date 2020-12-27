package com.reuben.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ResourceNotFoundException {

	private static final long serialVersionUID = 1L;
	
	private String message; 
	
	public ResourceNotFoundException(String message){
		 
		this.message = message; 
	}
	
	public String getMessage(){
		return this.message; 
	}
	
}
