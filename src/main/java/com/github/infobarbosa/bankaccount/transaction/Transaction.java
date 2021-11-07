package com.github.infobarbosa.bankaccount.transaction;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
    
    public Transaction(){}
    public Transaction(Long id, Float amount, Date date, Long creditAccount, Long debitAccount, TransactionType transactionType) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.creditAccount = creditAccount;
        this.debitAccount = debitAccount;
        this.transactionType = transactionType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Float amount;
    private Date date;
    private Long creditAccount;
    private Long debitAccount;
    private TransactionType transactionType;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction transaction = (Transaction) o;
        return Objects.equals(id, transaction.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.id );
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transaction{");
        sb.append("id=").append(id);
        sb.append("amount=").append(this.amount);
        sb.append(", date='").append(this.date).append('\'');
        sb.append("debitAccount=").append(this.debitAccount);
        sb.append("creditAccount=").append(this.creditAccount);
        sb.append("transactionType=").append(this.transactionType);
        sb.append('}');
        return sb.toString();
    }

    public enum TransactionType{
        TRANSFER,
        DEBIT,
        CREDIT;
    }

    public TransactionType getTransactionType() {
        return this.transactionType;
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param transactionType the transactionType to set
     */
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

}
