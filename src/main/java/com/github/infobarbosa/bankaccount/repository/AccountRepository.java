package com.github.infobarbosa.bankaccount.repository;

import com.github.infobarbosa.bankaccount.model.CheckingAccount;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<CheckingAccount, Long>{
    
}
