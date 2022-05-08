package com.github.infobarbosa.bankaccount.dto;

import com.github.infobarbosa.bankaccount.model.enums.AccountStatus;

public class AccountStatusRequest {
    private AccountStatus status;

    public void setStatus(AccountStatus status){
        this.status = status;
    }

    public AccountStatus getStatus(){
        return this.status;
    }

    public String toString(){
        return "AccountStatusDTO. accountStatus: " + status;
    }
}
