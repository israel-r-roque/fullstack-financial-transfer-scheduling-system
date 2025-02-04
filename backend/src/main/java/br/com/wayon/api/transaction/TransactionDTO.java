package br.com.wayon.api.transaction;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class TransactionDTO {
    private Long id;
    @NotBlank(message = "A conta de origem deve ser informada")
    @Size(min = 10, max = 10, message = "A conta de origem deve ter exatamente 10 caracteres")
    private String originAccount;

    @NotBlank(message = "A conta de origem deve ser informada")
    @Size(min = 10, max = 10, message = "A conta de destino deve ter exatamente 10 caracteres")
    private String destinationAccount;


    @NotNull(message = "O valor da transferência deve ser informado")
    @PositiveOrZero(message = "O valor da transferência deve ser positivo")
    @Digits(integer = 10, fraction = 2, message = "O valor da transferência pode ter no máximo 10 dígitos inteiros e 2 decimais")
    private BigDecimal amount;

    private BigDecimal fee;

    @NotNull(message = "A data da transferência deve ser informada")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate transferDate;
}
