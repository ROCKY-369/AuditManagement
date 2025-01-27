package com.authorizationservice.authorization.exceptions;

public class LoginException extends Exception {

    
    private static final long serialVersionUID = 1L;
    /**
     * This is a exception class where if we have a exception in login then it will throws a exception here.
     * Where it returns a message of the exception.
     * @param exceptionMessage
     */

    public LoginException(String exceptionMessage) {
        super(exceptionMessage);
	}
    
}
