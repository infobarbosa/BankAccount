package com.github.infobarbosa.bankaccount.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    

    public Customer create(Customer customer);
    public Customer update(Customer customer);

    public Optional<Customer> get(Long id);
    public List<Customer> getAll();
}
