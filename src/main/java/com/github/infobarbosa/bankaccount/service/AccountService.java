package com.github.infobarbosa.bankaccount.service;

import java.util.List;
import java.util.Optional;

import com.github.infobarbosa.bankaccount.model.CheckingAccount;

public interface AccountService {
    
    public List<CheckingAccount> findAll();

    public Optional<CheckingAccount> findById(Long accountId);

    public CheckingAccount createAccount(CheckingAccount checkingAccount);
    public CheckingAccount updateAccount(CheckingAccount checkingAccount);
    public void activateAccount(CheckingAccount checkingAccount);
    public void inactivateAccount(CheckingAccount checkingAccount);

}
