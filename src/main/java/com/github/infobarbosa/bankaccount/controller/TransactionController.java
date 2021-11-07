package com.github.infobarbosa.bankaccount.controller;

import com.github.infobarbosa.bankaccount.model.Transaction;
import com.github.infobarbosa.bankaccount.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    
    @Autowired
    private TransactionService service;

    @PostMapping(value="/transactions")
    public void postNewTransaction(Transaction transaction){
        service.process(transaction);
    }

}
