package br.com.vetornegocios.app.security;

public class AccountServiceException extends RuntimeException {

    public AccountServiceException(String message) {
        super(message);
    }
}
