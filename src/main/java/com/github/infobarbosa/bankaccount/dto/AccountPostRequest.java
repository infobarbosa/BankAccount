package com.github.infobarbosa.bankaccount.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AccountPostRequest {
    
    @NotNull(message = "customer id must not be null")
    private Long customerId;
    @NotBlank(message = "please inform a description for this account")
    private String description;

    public AccountPostRequest(){}

    public AccountPostRequest(Long customerId, String description){
        this.customerId = customerId;
        this.description = description;
    }

    public Long getCustomerId(){
        return this.customerId;
    }

    public void setCustomerId(Long customerId){
        this.customerId = customerId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append(", customerId=").append(customerId);
        sb.append(", name='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
