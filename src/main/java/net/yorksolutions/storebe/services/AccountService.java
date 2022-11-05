package net.yorksolutions.storebe.services;

import net.yorksolutions.storebe.dto.NewAccountRequestDTO;
import net.yorksolutions.storebe.entities.Account;
import net.yorksolutions.storebe.repositories.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AccountService {


    AccountRepository accountRepository;
    AccountService accountService;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
    }


    public Account create(NewAccountRequestDTO requestDTO) {


        try {
            return this.accountRepository.save(
                    new Account(requestDTO.firstname, requestDTO.lastname, requestDTO.email, requestDTO.username, requestDTO.password, requestDTO.rank));
        }
        catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

    }


    //this method will search the database for the accounts using the repo
    //this method does return an Optional in the form of Accounts
    public Account login(String username, String password) {
        Optional<Account> accountOpt = this.accountRepository.findByUsernameAndPassword(username, password);
        if (accountOpt.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND
            );
        }
        return accountOpt.get();
    }

    public boolean deleteById(Long id) {

      try {
        var userAccount = accountRepository.findById(id).orElseThrow();

        //delete the account in the repo
        accountRepository.deleteById(id);

        //delete was success = true
        return true;

    } catch (Exception e) {

          // If delete fail or error = false
          return false;
      }
    }
}
