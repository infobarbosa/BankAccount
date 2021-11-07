package com.github.infobarbosa.bankaccount.service;

import java.util.List;

import com.github.infobarbosa.bankaccount.model.CheckingAccount;
import com.github.infobarbosa.bankaccount.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    
    @Autowired
    private AccountRepository repository;

    @Override
    public List<CheckingAccount> findAll() {

        return (List<CheckingAccount>) repository.findAll();
    }
}
