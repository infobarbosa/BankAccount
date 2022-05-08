package com.github.infobarbosa.bankaccount.dto;

public class AccountDescriptionRequest {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AccountDescriptionRequest [description=" + description + "]";
    }
}
