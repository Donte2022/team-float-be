package net.yorksolutions.storebe.services;

import net.yorksolutions.storebe.dto.NewAccountRequestDTO;
import net.yorksolutions.storebe.dto.UpdateAccountRequestDTO;
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

                    new Account(requestDTO.firstName, requestDTO.lastName, requestDTO.email, requestDTO.username, requestDTO.password, requestDTO.rank, requestDTO.orderId));

        }
        catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

    }

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
        accountRepository.deleteById(id);
        return true;

    } catch (Exception e) {
          return false;
      }
    }


    public boolean updateAccount(UpdateAccountRequestDTO requestDTO, Long id) {
        try {
            Optional<Account> userAccount = this.accountRepository.findById(id);

            Account account = userAccount.get();
            account.setFirstName(requestDTO.firstName);
            account.setLastName(requestDTO.lastName);
            account.setEmail(requestDTO.email);
            account.setUsername(requestDTO.username);
            if (requestDTO.password.length() != 0)
                account.setPassword(requestDTO.password);
            account.setRank(requestDTO.rank);
            account.setOrderId(requestDTO.orderId);

            accountRepository.save(account);

            return true;

        } catch (Exception e) {
            return false;

        }
    }

//    public Account getAccountById(Long accountId) {
//
//       Optional<Account> accountOpt = this.accountRepository.findById(accountId);
//       if (accountOpt.isPresent()) {
//
//       }
//    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

}
