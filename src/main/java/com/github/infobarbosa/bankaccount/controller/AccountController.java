package com.github.infobarbosa.bankaccount.controller;

import java.util.List;
import java.util.Optional;

import com.github.infobarbosa.bankaccount.model.AccountStatus;
import com.github.infobarbosa.bankaccount.model.CheckingAccount;
import com.github.infobarbosa.bankaccount.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CheckingAccount> getAllAccounts(){
        return accountService.findAll();
    }

    @GetMapping(value="/accounts/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<CheckingAccount> getAccountById(@PathVariable(name="accountId") Long accountId){
        Optional<CheckingAccount> account = accountService.findById(accountId);
        return account;
    }

    @PostMapping(value="/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public CheckingAccount createAccount(@RequestBody CheckingAccount checkingAccount){
        CheckingAccount acc = accountService.createAccount(checkingAccount);
        return acc;
    }

    @PutMapping(value="/accounts/{id}")
    public CheckingAccount updateAccount(@RequestBody CheckingAccount checkingAccount){
        CheckingAccount acc = accountService.updateAccount(checkingAccount);
        return acc;
    }

    @PutMapping(value="/accounts/{id}")
    public CheckingAccount updateAccountStatus(@PathVariable(name = "id") Long accountId, @RequestBody AccountStatus accountStatus){
        CheckingAccount acc = accountService.findById(accountId).get();
        
        if( !acc.getAccountStatus().equals(accountStatus)){
            switch (accountStatus) {
                case ACTIVE:
                    accountService.activateAccount(acc);
                    break;
                case INACTIVE:
                    accountService.inactivateAccount(acc);
                default:
                    break;
            }
        }
        return acc;
    }

}
