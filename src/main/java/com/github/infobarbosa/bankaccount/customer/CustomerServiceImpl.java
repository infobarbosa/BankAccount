package com.github.infobarbosa.bankaccount.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll(){
        return (List<Customer>) customerRepository.findAll();
    }
}
