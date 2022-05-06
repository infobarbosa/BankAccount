package com.github.infobarbosa.bankaccount.dto;

import com.github.infobarbosa.bankaccount.model.AccountStatus;

public class AccountStatusDTO {
    private AccountStatus accountStatus;

    public void setAccountStatus(AccountStatus accountStatus){
        this.accountStatus = accountStatus;
    }

    public AccountStatus getAccountStatus(){
        return this.accountStatus;
    }

    public String toString(){
        return "AccountStatusDTO. accountStatus: " + accountStatus;
    }
}
