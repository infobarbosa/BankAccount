package com.github.infobarbosa.bankaccount.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.github.infobarbosa.bankaccount.model.enums.TransactionType;

@Entity
@Table(name="TBL_TRANSACTIONS")
public class Transaction {
    
    public Transaction(){}
    public Transaction(Long id, Float amount, Date date, Long creditAccount, Long debitAccount, TransactionType transactionType) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.creditAccountId = creditAccount;
        this.debitAccountId = debitAccount;
        this.transactionType = transactionType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="AMOUNT", nullable = false)
    private Float amount;
    @Column(name="TRANSACTION_DATE", nullable = false)
    private Date date;
    @Column(name="CREDIT_ACCOUNT_ID")
    private Long creditAccountId;
    @Column(name="DEBIT_ACCOUNT_ID")
    private Long debitAccountId;
    @Column(name="TRANSACTION_TYPE", nullable = false)
    private TransactionType transactionType;

    public Long getDebitAccount() {
        return debitAccountId;
    }

    public void setDebitAccount(Long debitAccount) {
        this.debitAccountId = debitAccount;
    }

    public Long getCreditAccount() {
        return creditAccountId;
    }

    public void setCreditAccount(Long creditAccount) {
        this.creditAccountId = creditAccount;
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
        sb.append("debitAccount=").append(this.debitAccountId);
        sb.append("creditAccount=").append(this.creditAccountId);
        sb.append("transactionType=").append(this.transactionType);
        sb.append('}');
        return sb.toString();
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

    public TransactionType getTransactionType() {
        return this.transactionType;
    }

    /**
     * @param transactionType the transactionType to set
     */
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

}
