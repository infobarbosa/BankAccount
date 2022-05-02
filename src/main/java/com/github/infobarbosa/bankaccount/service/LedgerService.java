package com.github.infobarbosa.bankaccount.service;

import com.github.infobarbosa.bankaccount.model.BookEntry;

public interface LedgerService {

    public void register(BookEntry bookEntry);
}
