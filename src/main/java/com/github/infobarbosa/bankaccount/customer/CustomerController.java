package com.github.infobarbosa.bankaccount.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {    
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @GetMapping(value = "/customers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Customer> get(@PathVariable Long id){
        return customerService.get( id );
    }

    @PostMapping(value = "/customers")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Customer create(@RequestBody Customer customer){
        return customerService.create( customer );
    }

    @PutMapping(value = "/customers/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Customer update(@RequestBody Customer customer, @PathVariable Long id){
        return customerService.update( customer, id );
    }

    @DeleteMapping(value = "/customers/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        customerService.delete( id );
    }
}
