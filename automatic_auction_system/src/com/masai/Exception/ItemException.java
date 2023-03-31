package com.masai.Exception;

public class ItemException extends Exception{
	String message;

	public ItemException(String message) {
		super(message);
	}

	public ItemException() {
		super();
	}
	
}
