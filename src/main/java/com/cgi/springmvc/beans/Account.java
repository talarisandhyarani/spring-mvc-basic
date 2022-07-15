package com.cgi.springmvc.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(nullable = false, length=10)
    private String accountType;

    @Column(nullable = false)
    private Long currentBalance;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customerId", nullable = false) 
    private Customer customer;

    @OneToMany(mappedBy = "sendCustomer", fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    private Set<Transaction> sentTransactions;

    @OneToMany(mappedBy = "recieveCustomer", fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    private Set<Transaction> recievedTransactions;

   

    protected Account(){}



    public Account(Long accountId, String accountType, Long currentBalance, Customer customer,
            Set<Transaction> sentTransactions, Set<Transaction> recievedTransactions) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.currentBalance = currentBalance;
        this.customer = customer;
        this.sentTransactions = sentTransactions;
        this.recievedTransactions = recievedTransactions;
    }

    public Long getAccountId() {
        return accountId;
    }



    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }



    public String getAccountType() {
        return accountType;
    }



    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }



    public Long getCurrentBalance() {
        return currentBalance;
    }



    public void setCurrentBalance(Long currentBalance) {
        this.currentBalance = currentBalance;
    }



    public Customer getCustomer() {
        return customer;
    }



    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



    public Set<Transaction> getSentTransactions() {
        return sentTransactions;
    }



    public void setSentTransactions(Set<Transaction> sentTransactions) {
        this.sentTransactions = sentTransactions;
    }



    public Set<Transaction> getRecievedTransactions() {
        return recievedTransactions;
    }



    public void setRecievedTransactions(Set<Transaction> recievedTransactions) {
        this.recievedTransactions = recievedTransactions;
    }
    

}