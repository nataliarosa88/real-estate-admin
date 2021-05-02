package br.com.vetornegocios.app.security;



import br.com.vetornegocios.app.security.AccountDetailRequestModel;
import br.com.vetornegocios.app.security.AccountRest;
import br.com.vetornegocios.app.security.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountRest createUser(@RequestBody AccountDetailRequestModel userDetails) {

        if (userDetails.getFirstName().isEmpty())
            throw new AccountServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getMessage());

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setFirstName( userDetails.getFirstName());
        accountDTO.setLastName( userDetails.getLastName());
        accountDTO.setEmail(userDetails.getEmail());
        accountDTO.setPassword(userDetails.getPassword());
        AccountDTO createdUser = accountService.create(accountDTO);

        AccountRest accountRest = new AccountRest();
        accountRest.setEmail(accountDTO.getEmail());
        return accountRest;
    }


}
