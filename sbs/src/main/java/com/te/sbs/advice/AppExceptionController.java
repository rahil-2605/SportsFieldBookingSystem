package com.te.sbs.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.sbs.exception.SomethingWentWrongException;
import com.te.sbs.exception.UserIdOrPasswordIncorrectException;
import com.te.sbs.exception.UserNotFoundException;
import com.te.sbs.response.AppResponse;

@RestControllerAdvice
public class AppExceptionController {

	@Autowired
	private AppResponse appResponse;

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<AppResponse> userNotFoundException(UserNotFoundException ex) {
		appResponse.setStatus("404");
		appResponse.setMessage(ex.getMessage());
		appResponse.setData(null);

		return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(UserIdOrPasswordIncorrectException.class)
	public ResponseEntity<AppResponse> userIdOrPasswordIncorrect(UserIdOrPasswordIncorrectException ex){
		
		appResponse.setStatus("401");
		appResponse.setMessage(ex.getMessage());
		appResponse.setData(null);
		
		return new ResponseEntity<AppResponse>(appResponse, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(SomethingWentWrongException.class)
	public ResponseEntity<AppResponse> somethingWentWrong(SomethingWentWrongException ex){
		
		appResponse.setStatus("401");
		appResponse.setMessage(ex.getMessage());
		appResponse.setData(null);
		
		return new ResponseEntity<AppResponse>(appResponse, HttpStatus.BAD_REQUEST);
		
	}

}
