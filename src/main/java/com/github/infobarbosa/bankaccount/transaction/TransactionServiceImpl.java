package com.github.infobarbosa.bankaccount.transaction;

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
        //TODO
    }

    private void processDebit(Transaction transaction) {
        //TODO
    }

    private void processCredit(Transaction transaction) {
        //TODO
    }
}
