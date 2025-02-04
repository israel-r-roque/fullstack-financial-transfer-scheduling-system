package br.com.wayon.api.account;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccountResponse {
    private String message;
    private AccountDTO account;
}
