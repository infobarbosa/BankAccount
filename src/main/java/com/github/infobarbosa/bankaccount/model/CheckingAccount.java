package com.github.infobarbosa.bankaccount.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_ACCOUNTS")
public class CheckingAccount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long customerId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Float balance;

    @Column(nullable = false)
    private AccountStatus accountStatus;

    public CheckingAccount(){}

    public CheckingAccount(Long customerId, String name, Float balance, AccountStatus accountStatus){
        this.customerId = customerId;
        this.name = name;
        this.balance = balance;
        this.accountStatus = accountStatus;
    }

    public CheckingAccount(Long id, Long customerId, String name, Float balance, AccountStatus accountStatus){
        this.id = id;
        this.customerId = customerId;
        this.name = name;
        this.balance = balance;
        this.accountStatus = accountStatus;
    }

    public Long getId() {
        return this.id;
    }

    public Long getCustomerId(){
        return this.customerId;
    }

    public void setCustomerId(Long customerId){
        this.customerId = customerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getBalance(){
        return this.balance;
    }

    public void setBalance(Float balance){
        this.balance = balance;
    }

    public AccountStatus getAccountStatus(){
        return this.accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus){
        this.accountStatus = accountStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckingAccount account = (CheckingAccount) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, name, balance);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("id=").append(id);
        sb.append(", customerId=").append(customerId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }
}
