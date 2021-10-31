package com.github.infobarbosa.bankaccount.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private static final String PATH = "/customers";
    
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getAll(){
        return customerService.getAll();
    }
}
