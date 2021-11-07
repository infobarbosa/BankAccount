package com.github.infobarbosa.bankaccount;

import com.github.infobarbosa.bankaccount.model.CheckingAccount;
import com.github.infobarbosa.bankaccount.model.Customer;
import com.github.infobarbosa.bankaccount.repository.AccountRepository;
import com.github.infobarbosa.bankaccount.repository.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabaseC(CustomerRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Customer("Ronaldo")));
      log.info("Preloading " + repository.save(new Customer("Marta")));
    };
  }


  @Bean
  CommandLineRunner initDatabaseA(AccountRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new CheckingAccount(1L, "Conta Corrente", 0.0f)));
      log.info("Preloading " + repository.save(new CheckingAccount(2L, "Conta Corrente", 10.0f)));
    };
  }
}