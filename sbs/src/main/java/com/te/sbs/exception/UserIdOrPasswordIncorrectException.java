package com.te.sbs.exception;

@SuppressWarnings("serial")
public class UserIdOrPasswordIncorrectException extends RuntimeException{
	public UserIdOrPasswordIncorrectException(String message) {
		super(message);
	}
	

}
