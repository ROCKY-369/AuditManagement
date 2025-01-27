package com.cognizant.auditchecklistmicroservice.exception;

public class InvalidTokenException extends RuntimeException {
	/**
	 * Its a exception class.
	 * @param message
	 */
    public InvalidTokenException(String message)
    {
    	super(message);
    }

}
