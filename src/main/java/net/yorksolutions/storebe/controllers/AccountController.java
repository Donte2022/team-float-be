package net.yorksolutions.storebe.controllers;

import net.yorksolutions.storebe.dto.NewAccountRequestDTO;
import net.yorksolutions.storebe.dto.UpdateAccountRequestDTO;
import net.yorksolutions.storebe.entities.Account;
import net.yorksolutions.storebe.services.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/account")
public class AccountController {
    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account create(@RequestBody NewAccountRequestDTO requestDTO) {
        return this.accountService.create(requestDTO);
    }

    static class Message {
        public String message;
        Message(String message) {
            this.message = message;
        }
    }
    @DeleteMapping("/{id}")
    Message deleteById(@PathVariable Long id) {
        return new Message (accountService.deleteById(id) ? "Account successfully deleted" : "Fail to delete account" );
    }

     @PutMapping("/{id}")
    public Message updateAccount(@RequestBody UpdateAccountRequestDTO requestDTO, @PathVariable Long id) {
        return new Message( accountService.updateAccount(requestDTO, id) ? "Account successfully updated" : "Fail to update account");
    }

    @GetMapping
    public Account login(@RequestParam String username, @RequestParam String password) {
        return this.accountService.login(username, password);
    }

    @GetMapping("/all")
    public Iterable<Account> getAll() {
        return this.accountService.getAllAccounts();
    }


}
