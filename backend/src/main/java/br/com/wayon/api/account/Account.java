package br.com.wayon.api.account;

import br.com.wayon.api.transaction.Transaction;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "Account")
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long accountId;

    @Column(name = "number", nullable = false, unique = true)
    private String accountNumber;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;
}
