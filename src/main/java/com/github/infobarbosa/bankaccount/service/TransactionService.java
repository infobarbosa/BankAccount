package com.github.infobarbosa.bankaccount.service;

import com.github.infobarbosa.bankaccount.model.Transaction;

public interface TransactionService {
    public void process(Transaction transaction);
}
