package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AllExceptionHandler 
{
@ExceptionHandler(OrderNotFound.class)

public ResponseEntity<ApiResponse> productNotFoundExceptionHandler(OrderNotFound ex)
{
	String message=ex.getMessage();
	ApiResponse apiResponse=new ApiResponse();
	return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	
}

}