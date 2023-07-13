package com.warranty.exception;

public class ClaimRecordNotFoundException extends RuntimeException{

    public ClaimRecordNotFoundException(String message){
        super(message);
    }
}
