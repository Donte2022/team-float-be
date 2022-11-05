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

//    @DeleteMapping
//    public Account delete() {
//
//    }

    //allow the FE to have access to the accounts to allow the client to login
    @GetMapping
    public Account login(@RequestParam String username, @RequestParam String password) {
        return this.accountService.login(username, password);
    }


}
