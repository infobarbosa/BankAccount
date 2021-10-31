package com.github.infobarbosa.bankaccount.customer;

import java.util.List;
import java.util.Optional;

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

    public Customer update(Customer customer){
        logger.debug( "Atualizando customer: " + customer.toString() );
        Customer updated = customerRepository.save(customer);
        return updated;
    }
}
