package net.yorksolutions.storebe.services;

import net.yorksolutions.storebe.dto.NewAccountRequestDTO;
import net.yorksolutions.storebe.dto.updateAccountRequestDTO;
import net.yorksolutions.storebe.dto.updateRankRequestDTO;
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

          //look for id if not present throw an error
        var userAccount = accountRepository.findById(id).orElseThrow();

        //delete the account in the repo
        accountRepository.deleteById(id);

        //delete was successful = true
        return true;

    } catch (Exception e) {

          //delete fail or error = false
          return false;
      }
    }


    public boolean updateAccount(updateAccountRequestDTO requestDTO, Long id) {

//        Optional<Account> userAccount = this.accountRepository.findById(id);
//
//        Account account = userAccount.get();
//
//            account.setFirstname(requestDTO.firstname);
//            account.setLastname(requestDTO.lastname);
//            account.setEmail(requestDTO.email);
//            account.setUsername(requestDTO.username);
//            account.setPassword(requestDTO.password);
//            account.setRank(requestDTO.rank);
//
//            return accountRepository.save(account);

        try {

            Optional<Account> userAccount = this.accountRepository.findById(id);

            Account account = userAccount.get();

            account.setFirstname(requestDTO.firstname);
            account.setLastname(requestDTO.lastname);
            account.setEmail(requestDTO.email);
            account.setUsername(requestDTO.username);
            account.setPassword(requestDTO.password);
            account.setRank(requestDTO.rank);

            accountRepository.save(account);

            //update was successful = true
            return true;

        } catch (Exception e) {

            //update fail or error = false
            return false;

        }
    }

    public boolean updateRank(updateRankRequestDTO requestDTO) {


        Optional<Account> userAccount = (accountRepository.findById(updateRankRequestDTO.id));
        Account account = userAccount.get();
            account.setRank( requestDTO.rank);

            //save the updated account in the repo
            this.accountRepository.save(account);

            //update was successful = true

        return true;

//        try {
//
//            //look for id if not present throw an error
//            Optional<Account> userAccount = Optional.of(accountRepository.findById(updateRankRequestDTO.id).orElseThrow());
//
//
//            Account account = userAccount.get();
//            account.setRank((Number) requestDTO.rank);
//
//            //save the updated account in the repo
//            this.accountRepository.save(account);
//
//            //update was successful = true
//            return true;
//
//        } catch (Exception e) {
//
//            //update fail or error = false
//            return false;
//        }
    }

}
