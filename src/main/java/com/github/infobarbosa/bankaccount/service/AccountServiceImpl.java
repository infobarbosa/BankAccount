package com.github.infobarbosa.bankaccount.service;

import java.util.List;
import java.util.Optional;

import com.github.infobarbosa.bankaccount.exception.AccountNotFoundException;
import com.github.infobarbosa.bankaccount.model.CheckingAccount;
import com.github.infobarbosa.bankaccount.model.enums.AccountStatus;
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
    public void changeAccountDescription(Long accountId, String description) {

        //TODO: 1. validar se checkingAccount é válido

        Optional<CheckingAccount> optionalAcc = repository.findById(accountId);
        if(optionalAcc.isPresent()){
            repository.changeAccountDescription(accountId, description);
        }
        else{
            throw new AccountNotFoundException("Account not found: " + accountId);
        }
    }

    @Override
    public void activateAccount(Long accountId){
        Optional<CheckingAccount> opt = repository.findById(accountId);
        if(opt.isPresent()){
            throw new AccountNotFoundException("Account not found: " + accountId);
        }

        repository.changeAccountStatus(accountId, AccountStatus.ACTIVE);
    }

    @Override
    public void inactivateAccount(Long accountId) {
        Optional<CheckingAccount> opt = repository.findById(accountId);
        if(!opt.isPresent()){
            throw new AccountNotFoundException("Account not found: " + accountId);
        }

        //TODO 1. validar se o chamador está tentando inativar uma conta que ainda tenha saldo positivo. Necessário sacar primeiro antes de inativar.

        repository.changeAccountStatus(accountId, AccountStatus.INACTIVE);        
    }

    @Override
    public void changeAccountBalance(Long accountId, Float balance) {
        //TODO 1. validar se o chamador está tentando alterar o saldo de uma conta com status inativo.

        repository.changeAccountBalance(accountId, balance);
        
    }

}
