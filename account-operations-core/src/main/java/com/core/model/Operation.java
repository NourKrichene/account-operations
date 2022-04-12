package com.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Operation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    BigDecimal amount;
    String label;
    Date creationDate;
    Long accountSender;
    Long accountReceiver;


    public Operation() {
    }


    public Operation(BigDecimal amount , String label , Date creationDate , Long accountSender , Long accountReceiver) {
        this.amount = amount;
        this.label = label;
        this.creationDate = creationDate;
        this.accountReceiver = accountReceiver;
        this.accountSender = accountSender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


    public void setAccountReceiver(Long accountReceiver) {
        this.accountReceiver = accountReceiver;
    }

    public void setAccountSender(Long accountSender) {
        this.accountSender = accountSender;
    }

    public Long getAccountSender() {
        return accountSender;
    }

    public Long getAccountReceiver() {
        return accountReceiver;
    }

    @Override
    public String toString() {
        return "Operation{" + "amount=" + amount + ", label='" + label + '\'' + ", creationDate=" + creationDate + ", accountSender=" + accountSender + ", accountReceiver=" + accountReceiver + '}';
    }
}
