package br.com.wayon.api.transaction;

import br.com.wayon.api.account.Account;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Setter
@Getter
@ToString
@Table(name = "Transaction")
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "origin_account_id", nullable = false)
    private String originAccount;

    @Column(name = "destination_account_id", nullable = false)
    private String destinationAccount;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal fee;

    @Column(name = "transfer_date", nullable = false)
    private LocalDate transferDate;

    @Column(name = "scheduling_date", nullable = false)
    private Instant schedulingDate;

    public void  calculateValueToBeTransferred(BigDecimal feeAmount) {
        this.fee = feeAmount;
        this.amount = this.amount.add(this.fee);
    }
}
