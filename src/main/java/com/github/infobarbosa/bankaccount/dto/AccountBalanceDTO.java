package com.github.infobarbosa.bankaccount.dto;

public class AccountBalanceDTO {
    private Float balance;

    public void setBalance(Float balance){
        this.balance = balance;
    }

    public Float getBalance(){
        return this.balance;
    }

    public String toString(){
        return "AccountBalanceDTO. balance: " + balance;
    }
}
