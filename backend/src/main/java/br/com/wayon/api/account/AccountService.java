package br.com.wayon.api.account;

import br.com.wayon.api.exception.DuplicateAccountException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountDTO createAccount(AccountDTO dto) {
        try {
            Account account = modelMapper.map(dto, Account.class);
            Account savedAccount = accountRepository.save(account);

            return modelMapper.map(savedAccount, AccountDTO.class);
        } catch (DataIntegrityViolationException exception) {
            throw new DuplicateAccountException("Já existe uma conta com esse número.");
        }

    }

    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll(Sort.by(Sort.Direction.ASC, "accountId"));
        return accounts.stream().map(account -> modelMapper.map(account, AccountDTO.class)).collect(Collectors.toList());
    }

    public AccountDTO findByAccountId(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada com o ID fornecido" + id));
        return modelMapper.map(account, AccountDTO.class);
    }

    public AccountDTO findByAccountNumber(String number) {
        Account account = accountRepository.findByAccountNumber(number);
        return modelMapper.map(account, AccountDTO.class);
    }
}
