package com.pratik.application_service.exceptions;

public class NoApplicationsFoundException extends RuntimeException{
    public NoApplicationsFoundException(String message){
        super(message);
    }
}
