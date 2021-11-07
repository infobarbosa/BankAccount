package com.github.infobarbosa.bankaccount.service;

import java.util.List;

import com.github.infobarbosa.bankaccount.model.CheckingAccount;

public interface AccountService {
    
    public List<CheckingAccount> findAll();
}
