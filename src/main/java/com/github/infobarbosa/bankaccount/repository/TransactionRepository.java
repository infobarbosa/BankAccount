package com.github.infobarbosa.bankaccount.repository;

import com.github.infobarbosa.bankaccount.model.Transaction;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long>{

}
