package com.github.infobarbosa.bankaccount.service;

import java.util.List;
import java.util.Optional;

import com.github.infobarbosa.bankaccount.model.CheckingAccount;

public interface AccountService {
    
    public List<CheckingAccount> findAll();

    public Optional<CheckingAccount> findById(Long accountId);
}
