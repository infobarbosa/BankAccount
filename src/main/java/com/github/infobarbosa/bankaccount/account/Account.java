package com.github.infobarbosa.bankaccount.account;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_ACCOUNTS")
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;
    private String name;
    private Float balance;

    public Account(){}

    public Account(Long customerId, String name, Float balance){
        this.customerId = customerId;
        this.name = name;
        this.balance = balance;
    }

    public Account(Long id, Long customerId, String name, Float balance){
        this.id = id;
        this.customerId = customerId;
        this.name = name;
        this.balance = balance;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
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
        sb.append("customerId=").append(customerId);
        sb.append(", name='").append(name).append('\'');
        sb.append("balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }
}
