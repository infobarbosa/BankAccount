package com.github.infobarbosa.bankaccount.repository;

import com.github.infobarbosa.bankaccount.model.CheckingAccount;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<CheckingAccount, Long>{
 
    @Modifying
    @Query("update tbl_accounts acc set acc.balance = :balance where acc.id = :id")
    int updateAccountBalance(@Param("id") Long id, @Param("balance") Float balance);
}
