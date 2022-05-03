package com.github.infobarbosa.bankaccount.service;

import com.github.infobarbosa.bankaccount.exception.InvalidAccountException;

import java.util.Date;

import com.github.infobarbosa.bankaccount.exception.InsufficientFundsException;
import com.github.infobarbosa.bankaccount.model.BookEntry;
import com.github.infobarbosa.bankaccount.model.BookEntryType;
import com.github.infobarbosa.bankaccount.model.CheckingAccount;
import com.github.infobarbosa.bankaccount.model.Transaction;
import com.github.infobarbosa.bankaccount.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService{
    
    @Autowired
    private TransactionRepository repository;

    @Autowired
    private LedgerService ledgerService;

    public void process(Transaction transaction) {
        //TODO: 1. Verificar se a conta de débito é uma conta válida (existe e está ativa)
        //TODO: 2. Verificar se a conta de débito tem saldo

        repository.save(transaction);

        switch (transaction.getTransactionType()) {
            case DEPOSIT:
                processDeposit(transaction);
                break;
            case WITHDRAW:
                processWithdraw(transaction);
                break;
            case TRANSFER:
                processTransfer(transaction);
                break;
            default:
                break;
        }
    }

    private void processDeposit(Transaction transaction) {

        BookEntry bookEntry = new BookEntry();
        bookEntry.setAccountId(transaction.getCreditAccount());
        bookEntry.setAmount(transaction.getAmount());
        bookEntry.setDate(new Date());
        bookEntry.setEntryType(BookEntryType.CREDIT);
    }

    private void processWithdraw(Transaction transaction) {

        BookEntry bookEntry = new BookEntry();
        bookEntry.setAccountId(transaction.getDebitAccount());
        bookEntry.setAmount(transaction.getAmount());
        bookEntry.setDate(new Date());
        bookEntry.setEntryType(BookEntryType.DEBIT);
    }

    private void processTransfer(Transaction transaction) {
        //TODO: Verificar se a conta de débito tem saldo

        //Entrada de débito no livro razão
        BookEntry debitBookEntry = new BookEntry();
        debitBookEntry.setAccountId(transaction.getDebitAccount());
        debitBookEntry.setAmount(transaction.getAmount());
        debitBookEntry.setDate(new Date());
        debitBookEntry.setEntryType(BookEntryType.DEBIT);
        ledgerService.register(debitBookEntry);

        //Entrada de crédito no livro razão
        BookEntry creditBookEntry = new BookEntry();
        creditBookEntry.setAccountId(transaction.getCreditAccount());
        creditBookEntry.setAmount(transaction.getAmount());
        creditBookEntry.setDate(new Date());
        creditBookEntry.setEntryType(BookEntryType.CREDIT);
        ledgerService.register(creditBookEntry);
    }


    private void verityIfAccountIsValid(CheckingAccount account) throws InvalidAccountException{
        //TODO
    }

    private void verifyIfAccountHaveFunds(CheckingAccount account) throws InsufficientFundsException{
        //TODO
    }
}
