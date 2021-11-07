package com.github.infobarbosa.bankaccount.controller;

import java.util.List;

import com.github.infobarbosa.bankaccount.model.CheckingAccount;
import com.github.infobarbosa.bankaccount.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CheckingAccount> getAllAccounts(){
        return accountService.findAll();
    }
}
