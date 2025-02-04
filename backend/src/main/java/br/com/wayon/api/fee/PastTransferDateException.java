package br.com.wayon.api.fee;

public class PastTransferDateException extends IllegalArgumentException {
    public PastTransferDateException(String message) {
        super(message);
    }
}
