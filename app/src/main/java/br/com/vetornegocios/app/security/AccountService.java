package br.com.vetornegocios.app.security;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    AccountDTO create(AccountDTO accountDTO);

    AccountDTO getAccountByAccountId(String id);

    String getAccountByEmail(String email);




}
