package com.github.infobarbosa.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    
    @Autowired
    private AccountRepository repository;

    @Override
    public List<Account> findAll() {

        return (List<Account>) repository.findAll();
    }
}
