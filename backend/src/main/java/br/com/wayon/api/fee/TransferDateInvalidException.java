package br.com.wayon.api.fee;

public class TransferDateInvalidException extends IllegalArgumentException {
    public TransferDateInvalidException(String message) {
        super(message);
    }
}
