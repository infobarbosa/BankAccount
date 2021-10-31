package com.github.infobarbosa.bankaccount.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @GetMapping(value = PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Customer> get(@PathVariable Long id){
        return customerService.get( id );
    }

    @PostMapping(value = PATH)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Customer create(Customer customer){
        return customerService.create( customer );
    }

    @PutMapping(value = PATH)
    @ResponseStatus(code = HttpStatus.OK)
    public Customer update(Customer customer){
        return customerService.update( customer );
    }
}
