package br.com.wayon.api.transaction;

import br.com.wayon.api.account.Account;
import br.com.wayon.api.account.AccountDTO;
import br.com.wayon.api.account.AccountService;
import br.com.wayon.api.fee.Fee;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountService accountService;
    private final ModelMapper modelMapper;
    private final Fee fee;

    @Transactional
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = modelMapper.map(transactionDTO, Transaction.class);

        // 1. Buscar as contas de origem e destino pelos IDs
        AccountDTO originAccountDTO = accountService.findByAccountNumber(transactionDTO.getOriginAccount());
        AccountDTO destinationAccountDTO = accountService.findByAccountNumber(transactionDTO.getDestinationAccount());

        Account originAccount = modelMapper.map(originAccountDTO, Account.class);
        Account destinationAccount = modelMapper.map(destinationAccountDTO, Account.class);

        // 2. Associar as contas à transação
        transaction.setAccount(originAccount);
        transaction.setOriginAccount(originAccount.getAccountNumber());
        transaction.setDestinationAccount(destinationAccount.getAccountNumber());

        // 4. Configurar dados da transação
        transaction.setSchedulingDate(Instant.now());
        fee.calculate(transaction.getTransferDate(),transaction.getSchedulingDate(), transaction.getAmount());
        transaction.calculateValueToBeTransferred(fee.getTotalAmount());

        System.out.println("----DADOS DA TRANSAÇÃO: " + transactionDTO);
        System.out.println("----MAPEAMENTO DTO: " + transactionDTO);

        // 5. Salvar a transação
        Transaction savedTransaction = transactionRepository.save(transaction);

        System.out.println("----TRANSAÇÃO SALVA: " + savedTransaction);

        // 6. Retornar transaçãoDTO para o controller
        return modelMapper.map(savedTransaction, TransactionDTO.class);
    }

    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(transaction -> modelMapper.map(transaction, TransactionDTO.class))
                .collect(Collectors.toList());
    }
}