package com.masai.Exception;

public class AuctionException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuctionException(String message) {
        super(message);
    }

    public AuctionException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public void logException() {
        // Code to log the exception
    }
}

