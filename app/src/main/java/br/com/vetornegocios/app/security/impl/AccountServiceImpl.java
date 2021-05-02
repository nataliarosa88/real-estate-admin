package br.com.vetornegocios.app.security.impl;


import br.com.vetornegocios.app.security.*;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class AccountServiceImpl implements AccountService {



    private final AccountRepository accountRepository;
    private final Utils utils;
    private final PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AccountRepository accountRepository, Utils utils, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.utils = utils;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email);

        if (account == null) {
            throw new UsernameNotFoundException(email);
        }

        return new org.springframework.security.core.userdetails.User(account.getEmail(), account.getEncryptedPassword(), new ArrayList<>());
    }


    @Override
    public AccountDTO create(AccountDTO accountDTO) {
        if (accountRepository.findByEmail(accountDTO.getEmail()) != null) {
            throw new AccountServiceException("Record with " + accountDTO.getAccountId() + " already exists!");
        }

        Account account = new Account();
        account.setEmail(accountDTO.getEmail());
        account.setFirstName(accountDTO.getFirstName());
        account.setLastName(accountDTO.getLastName());
        account.setEncryptedPassword(passwordEncoder.encode(accountDTO.getPassword()));
        account.setAccountId(utils.generateAccountId(30));
        Account accountSave = accountRepository.save(account);
        accountDTO.setEmail(accountSave.getEmail());
        return accountDTO;
    }

    @Override
    public AccountDTO getAccountByAccountId(String accountId) {
        Account account = accountRepository.findByAccountId(accountId);
        if (account == null) {
            throw new UsernameNotFoundException(accountId);
        }
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail(account.getEmail());
        return accountDTO;
    }


    @Override
    public String getAccountByEmail(String email) {
        Account account = accountRepository.findByEmail(email);

        if (account == null) {
            throw new UsernameNotFoundException(email);
        }

        return account.getAccountId();
    }


}
