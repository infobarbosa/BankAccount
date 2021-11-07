package com.github.infobarbosa.bankaccount.repository;

import com.github.infobarbosa.bankaccount.model.Customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
    
}