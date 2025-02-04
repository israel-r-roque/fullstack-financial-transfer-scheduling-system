package br.com.wayon.api.account;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AccountDTO {

    private Long accountId;

    @NotNull(message = "O número da conta é obrigatório")
    @NotEmpty(message = "O número da conta não pode ser vazio")
    @Size(min = 10, max = 10, message = "O número da conta deve ter exatamente 10 caracteres")
    private String accountNumber;
}
