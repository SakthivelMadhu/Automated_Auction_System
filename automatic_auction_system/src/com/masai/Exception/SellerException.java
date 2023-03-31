package com.masai.Exception;

public class SellerException extends Exception{
	String message;

	public SellerException() {
		super();
	}

	public SellerException(String message) {
		super(message);
	}
	
}
