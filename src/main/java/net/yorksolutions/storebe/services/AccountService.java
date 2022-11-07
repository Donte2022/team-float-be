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

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Account create(NewAccountRequestDTO requestDTO) {


        try {
            return this.accountRepository.save(
                    new Account(requestDTO.firstName, requestDTO.lastName, requestDTO.email, requestDTO.username, requestDTO.password, requestDTO.rank));
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

//    public Account deleteById(Long id) {
//
//        try {
//            final var useraccount = AccountRepository.findById(id).orElseThrow();
//
//            AccountService.removeEmployeeFromAllManagers(useraccount);
//
//            AccountRepository.deleteById(id);
//
//            return true;
//
//        } catch (Exception e) {
//
//            //
//            return false;
//        }
//
//    }
}
