package com.github.infobarbosa.bankaccount.service;

import java.util.List;
import java.util.Optional;

import com.github.infobarbosa.bankaccount.model.Customer;

public interface CustomerService {
    

    public Customer create(Customer customer);
    public Customer update(Customer customer, Long id);

    public Optional<Customer> get(Long id);
    public List<Customer> getAll();
    public void delete(Long id);
}
