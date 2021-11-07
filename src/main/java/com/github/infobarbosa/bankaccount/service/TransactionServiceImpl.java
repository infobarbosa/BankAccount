package com.github.infobarbosa.bankaccount.service;

import com.github.infobarbosa.bankaccount.exception.InvalidAccountException;
import com.github.infobarbosa.bankaccount.exception.InsufficientFundsException;
import com.github.infobarbosa.bankaccount.model.CheckingAccount;
import com.github.infobarbosa.bankaccount.model.Transaction;
import com.github.infobarbosa.bankaccount.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository repository;

    public void process(Transaction transaction) {


        switch (transaction.getTransactionType()) {
            case CREDIT:
                processCredit(transaction);
                break;
            case DEBIT:
                processDebit(transaction);
                break;
            case TRANSFER:
                processTransfer(transaction);
                break;
            default:
                break;
        }
    }

    private void processTransfer(Transaction transaction) {
        //Verificar se a conta de débito tem saldo
    }

    private void processDebit(Transaction transaction) {
        //1. Verificar se a conta de débito é uma conta válida (existe e está ativa)
        //2. Verificar se a conta de débito tem saldo
    }

    private void processCredit(Transaction transaction) {
        //TODO
    }

    private void verityIfAccountIsValid(CheckingAccount account) throws InvalidAccountException{
        //TODO
    }

    private void verifyIfAccountHaveFunds(CheckingAccount account) throws InsufficientFundsException{
        //TODO
    }
}
