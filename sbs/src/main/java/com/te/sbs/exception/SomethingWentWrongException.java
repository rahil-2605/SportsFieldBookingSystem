package com.te.sbs.exception;

@SuppressWarnings("serial")
public class SomethingWentWrongException extends RuntimeException {
	public SomethingWentWrongException(String message) {
		super(message);
	}
}
