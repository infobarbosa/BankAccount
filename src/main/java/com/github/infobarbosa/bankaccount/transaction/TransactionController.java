package com.github.infobarbosa.bankaccount.transaction;

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
