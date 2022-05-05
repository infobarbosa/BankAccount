package com.github.infobarbosa.bankaccount.service;

import java.util.List;
import java.util.Optional;

import com.github.infobarbosa.bankaccount.exception.AccountNotFoundException;
import com.github.infobarbosa.bankaccount.model.AccountStatus;
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

    @Override
    public Optional<CheckingAccount> findById(Long accountId) {
        return repository.findById(accountId);
    }

    @Override
    public CheckingAccount createAccount(CheckingAccount checkingAccount) {
        repository.save(checkingAccount);
        return checkingAccount;
    }

    @Override
    public void updateAccount(CheckingAccount checkingAccount) {
        repository.save(checkingAccount);

        //TODO: 1. validar se checkingAccount é válido

        Optional<CheckingAccount> optionalAcc = repository.findById(checkingAccount.getId());
        if(optionalAcc.isPresent()){
            repository.save(checkingAccount);
        }
        else{
            throw new AccountNotFoundException("Account not found: " + checkingAccount.getId());
        }
    }

    @Override
    public void activateAccount(Long accountId){
        Optional<CheckingAccount> optionalAcc = repository.findById(accountId);
        if(optionalAcc.isPresent()){
            CheckingAccount acc = optionalAcc.get();
            acc.setAccountStatus(AccountStatus.ACTIVE);
            repository.save(acc);
        }
        else{
            throw new AccountNotFoundException("Account not found: " + accountId);
        }
        
    }

    @Override
    public void inactivateAccount(Long accountId) {
        Optional<CheckingAccount> optionalAcc = repository.findById(accountId);
        if(optionalAcc.isPresent()){
            CheckingAccount acc = optionalAcc.get();
            acc.setAccountStatus(AccountStatus.INACTIVE);
            repository.save(acc);
        }
        else{
            throw new AccountNotFoundException("Account not found: " + accountId);
        }
        
    }

    @Override
    public void updateBalance(Long accountId, Float balance) {
        repository.updateAccountBalance(accountId, balance);
        
    }
}
