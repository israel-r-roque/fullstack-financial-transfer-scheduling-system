package br.com.wayon.api.exception;

public class InvalidRequestDataException extends RuntimeException{
    public InvalidRequestDataException(String message) {
        super(message);
    }
}
