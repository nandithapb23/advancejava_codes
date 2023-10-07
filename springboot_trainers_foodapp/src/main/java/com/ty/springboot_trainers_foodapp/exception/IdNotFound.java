package com.ty.springboot_trainers_foodapp.exception;

public class IdNotFound extends RuntimeException {

	private String message = "Id Not Found";

	public IdNotFound(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
