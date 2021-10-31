package com.github.infobarbosa.bankaccount.transaction;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {
    
    @Id
    private Long id;
    
    public Transaction(Long id, Float amount, Date date, Long creditAccount, Long debitAccount) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.creditAccount = creditAccount;
        this.debitAccount = debitAccount;
    }

    private Float amount;
    private Date date;
    private Long creditAccount;
    private Long debitAccount;

    protected Transaction(){}

    public Long getDebitAccount() {
        return debitAccount;
    }

    public void setDebitAccount(Long debitAccount) {
        this.debitAccount = debitAccount;
    }

    public Long getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(Long creditAccount) {
        this.creditAccount = creditAccount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

}
