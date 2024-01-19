package io.bytecode.exception;


public class AppointmentServiceException extends RuntimeException{
    public AppointmentServiceException(String message, Exception ex) {
        super(message, ex);
    }
    public AppointmentServiceException(String message) {
        super(message);
    }
}