package com.eazybytes.accounts.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.eazybytes.accounts.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler extends Exception{
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> handleException(Exception exception,
			WebRequest webRequest){
		ErrorResponseDto errorResponseDto=new ErrorResponseDto(
				webRequest.getDescription(false),
				HttpStatus.INTERNAL_SERVER_ERROR,
				exception.getMessage(),
				LocalDateTime.now()
				);
		return new ResponseEntity<>(errorResponseDto,HttpStatus.INTERNAL_SERVER_ERROR);
				
	}
	
	@ExceptionHandler(CustomerAlreadyExistException.class)
	public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistException(CustomerAlreadyExistException 
			exception, WebRequest webRequest){
		ErrorResponseDto errorResponseDto=new ErrorResponseDto(
				webRequest.getDescription(false),
				HttpStatus.BAD_GATEWAY,
				exception.getMessage(),
				LocalDateTime.now());
		
		return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_GATEWAY);
				
		
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception,
			WebRequest webRequest){
		ErrorResponseDto errorResponse=new ErrorResponseDto(
				webRequest.getDescription(false),
				HttpStatus.NOT_FOUND,
				exception.getMessage(),
				LocalDateTime.now()
				
				);
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}

}
