package com.cgi.springmvc.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")

public class Transaction{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "sendCustomerId", nullable = false)
    private Customer sendCustomer;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "recieveCustomerId", nullable = false)
    private Customer recieveCustomer;

    protected Transaction(){}

    public Transaction(Long transactionId, Long amount, Date date, Customer sendCustomer, Customer recieveCustomer) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.date = date;
        this.sendCustomer = sendCustomer;
        this.recieveCustomer = recieveCustomer;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getSendCustomer() {
        return sendCustomer;
    }

    public void setSendCustomer(Customer sendCustomer) {
        this.sendCustomer = sendCustomer;
    }

    public Customer getRecieveCustomer() {
        return recieveCustomer;
    }

    public void setRecieveCustomer(Customer recieveCustomer) {
        this.recieveCustomer = recieveCustomer;
    }

    

    
}
