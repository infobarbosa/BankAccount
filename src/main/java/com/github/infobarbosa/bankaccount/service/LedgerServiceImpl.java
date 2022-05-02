package com.github.infobarbosa.bankaccount.service;

import com.github.infobarbosa.bankaccount.model.BookEntry;
import com.github.infobarbosa.bankaccount.repository.LedgerRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class LedgerServiceImpl implements LedgerService{
    
    @Autowired
    private LedgerRepository repository;

    public void register(BookEntry bookEntry) {
        repository.save(bookEntry);
    }

}
