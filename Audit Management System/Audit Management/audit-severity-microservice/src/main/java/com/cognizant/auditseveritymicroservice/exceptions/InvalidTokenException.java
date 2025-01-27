package com.cognizant.auditseveritymicroservice.exceptions;

public class InvalidTokenException extends RuntimeException{
    /**
     * This is a exception class when ther is an exception it will return the exception
     * @param message
     */
    public InvalidTokenException(String message){
        super(message);
    }
    
}
