package com.github.infobarbosa.bankaccount.repository;

import com.github.infobarbosa.bankaccount.model.AccountStatus;
import com.github.infobarbosa.bankaccount.model.CheckingAccount;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountRepository extends CrudRepository<CheckingAccount, Long>{
 
    @Modifying
    @Transactional
    @Query("UPDATE CheckingAccount ACC SET ACC.balance = :balance WHERE ACC.id = :id")
    int changeAccountBalance(@Param("id") Long id, @Param("balance") Float balance);

    @Modifying
    @Transactional
    @Query("UPDATE CheckingAccount ACC SET ACC.accountStatus = :account_status WHERE ACC.id = :id")
    int changeAccountStatus(@Param("id") Long id, @Param("account_status") AccountStatus accountStatus);

}
