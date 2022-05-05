package com.github.infobarbosa.bankaccount.dto;

public class AccountBalanceDTO {
    private Float balance;

    public void setAccountBalance(Float balance){
        this.balance = balance;
    }

    public Float getAccountBalance(){
        return this.balance;
    }
}
