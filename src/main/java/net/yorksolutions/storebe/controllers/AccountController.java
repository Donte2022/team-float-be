package net.yorksolutions.storebe.controllers;

import net.yorksolutions.storebe.dto.NewAccountRequestDTO;
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
        //get a boolean if the delete was a success or fail
     //wrap the reply from the delete method inside of Message object
     //to trigger jackson into convert it into Json format to help the front end
     return new Message (accountService.deleteById(id) ? "Account successfully deleted" : "Fail to delete account" );
 }

    //allow the FE to have access to the accounts to allow the client to login
    @GetMapping
    public Account login(@RequestParam String username, @RequestParam String password) {
        return this.accountService.login(username, password);
    }


}
