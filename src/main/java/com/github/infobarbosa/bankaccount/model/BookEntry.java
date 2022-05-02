package com.github.infobarbosa.bankaccount.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BookEntry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private Float amount;
    @Column(nullable=false)
    private Date date;
    @Column(nullable=false)
    private Long accountId;
    @Column(nullable=false)
    private BookEntryType bookEntryType;
    
    public BookEntry(){}
    public BookEntry(Long id, Float amount, Date date, Long accountId, BookEntryType bookEntryType) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.accountId = accountId;
        this.bookEntryType = bookEntryType;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Float getAmount(){
        return this.amount;
    }

    public void setAmount(Float amount){
        this.amount = amount;
    }

    public Date getDate(){
        return this.date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Long accountId(){
        return this.accountId;
    }

    public void setAccountId(Long accountId){
        this.accountId = accountId;
    }

    public BookEntryType getEntryType(){
        return this.bookEntryType;
    }

    public void setEntryType(BookEntryType bookEntryType){
        this.bookEntryType = bookEntryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntry bookEntry = (BookEntry) o;
        return Objects.equals(this.id, bookEntry.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("id=").append(this.id);
        sb.append(", amount='").append(this.amount).append('\'');
        sb.append(", accountId='").append(this.accountId).append('\'');
        sb.append(", date='").append(this.date).append('\'');
        sb.append(", bookEntryType='").append(this.bookEntryType).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
