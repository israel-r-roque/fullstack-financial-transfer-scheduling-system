package br.com.wayon.api.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TransactionResponse {
    private String message;
    private TransactionDTO transaction;
}
