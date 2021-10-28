package com.student.exceptionhandler;

public class InternalServerError extends RuntimeException {

	public InternalServerError(String message) {
        super(message);
    }
}
