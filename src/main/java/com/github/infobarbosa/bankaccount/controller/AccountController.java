package com.github.infobarbosa.bankaccount.controller;

import java.util.List;
import java.util.Optional;

import com.github.infobarbosa.bankaccount.dto.AccountBalanceDTO;
import com.github.infobarbosa.bankaccount.dto.AccountStatusDTO;
import com.github.infobarbosa.bankaccount.model.AccountStatus;
import com.github.infobarbosa.bankaccount.model.CheckingAccount;
import com.github.infobarbosa.bankaccount.service.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CheckingAccount>> getAllAccounts(){
        logger.info("getAllAccounts chamado...");
        List<CheckingAccount> accountList = accountService.findAll();
        return new ResponseEntity<List<CheckingAccount>>(accountList, HttpStatus.OK);
    }

    @GetMapping(value="/accounts/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CheckingAccount> getAccountById(@PathVariable(name="accountId") Long accountId){
        Optional<CheckingAccount> optAccount = accountService.findById(accountId);
        if(optAccount.isPresent()){
            CheckingAccount acc = optAccount.get();
            return new ResponseEntity<CheckingAccount>(acc, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value="/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CheckingAccount> createAccount(@RequestBody CheckingAccount checkingAccount){
        CheckingAccount acc = accountService.createAccount(checkingAccount);
        return new ResponseEntity<CheckingAccount>(acc, HttpStatus.CREATED);
    }

    @PutMapping(value="/accounts/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Void> updateAccount(@RequestBody CheckingAccount checkingAccount){
        accountService.updateAccount(checkingAccount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value="/accounts/{id}/status")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Void> changeAccountStatus(@PathVariable(name = "id") Long accountId, @RequestBody AccountStatusDTO accountStatus){
        logger.info("valor de accountStatus: " + accountStatus);

        Optional<CheckingAccount> opt = accountService.findById(accountId);
        
        if(!opt.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        CheckingAccount acc = opt.get();
        if( !acc.getAccountStatus().equals(accountStatus.getAccountStatus())){
            switch (accountStatus.getAccountStatus()) {
                case ACTIVE:
                    accountService.activateAccount(accountId);
                    break;
                case INACTIVE:
                    accountService.inactivateAccount(accountId);
                default:
                    break;
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping(value="/accounts/{id}/balance")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Void> changeAccountBalance(@PathVariable(name = "id") Long accountId, @RequestBody AccountBalanceDTO balance){
        Optional<CheckingAccount> oAcc = accountService.findById(accountId);
        if(!oAcc.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("valor de balance: " + balance.getBalance());
    
        accountService.changeAccountBalance(accountId, balance.getBalance());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
