package com.github.infobarbosa.bankaccount.service;

import java.util.List;
import java.util.Optional;

import com.github.infobarbosa.bankaccount.model.Customer;
import com.github.infobarbosa.bankaccount.repository.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final Logger logger = LoggerFactory.getLogger( CustomerServiceImpl.class.getName() );

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll(){
        return (List<Customer>) customerRepository.findAll();
    }

    public Optional<Customer> get(Long id){
        return customerRepository.findById( id );
    }

    public Customer create(Customer customer) {
        Customer created = customerRepository.save( customer );
        logger.debug( created.toString() );
        return created;
    }

    public Customer update(Customer customer, Long id){
        logger.debug( "Atualizando customer: " + customer.toString() );

        return customerRepository.findById(id)
            .map(employee -> {
                employee.setName(customer.getName());
                return customerRepository.save( customer );
            })
            .orElseGet(() -> {
                customer.setId(id);
                return customerRepository.save( customer );
            });
    }

    public void delete( Long id ){
        customerRepository.deleteById(id);
    }
}
