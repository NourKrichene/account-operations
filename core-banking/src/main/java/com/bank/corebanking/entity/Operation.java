package com.bank.corebanking.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Operation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    BigDecimal amount;
    String label;
    Date executionDate;
    boolean withdrawal;
    Long accountSender;
    Long accountReceiver;


    public Operation() {
    }


    public Operation(BigDecimal amount , String label , Date executionDate , boolean withdrawal  , Long accountSender, Long accountReceiver) {
        this.amount = amount;
        this.label = label;
        this.executionDate = executionDate;
        this.withdrawal = withdrawal;
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

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public boolean isWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(boolean withdrawal) {
        this.withdrawal = withdrawal;
    }


    public void setAccountReceiver(Long accountReceiver) {
        this.accountReceiver = accountReceiver;
    }

    public void setAccountSender(Long accountSender) {
        this.accountSender = accountSender;
    }

    @Override
    public String toString() {
        return "Operation{" + "amount=" + amount + ", label='" + label + '\'' + ", executionDate=" + executionDate + ", withdrawal=" + withdrawal + ", accountSender=" + accountSender + ", accountReceiver=" + accountReceiver + '}';
    }
}
