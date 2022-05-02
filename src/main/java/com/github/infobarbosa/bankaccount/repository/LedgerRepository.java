package com.github.infobarbosa.bankaccount.repository;

import com.github.infobarbosa.bankaccount.model.BookEntry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedgerRepository extends CrudRepository<BookEntry, Long>{
    
}
