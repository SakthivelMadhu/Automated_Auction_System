package com.masai.Exception;

public class AdministratorException extends Exception{
	String message;

	public AdministratorException() {
		super();
	}
	
	public AdministratorException(String message) {
		super(message);
		
	}
}