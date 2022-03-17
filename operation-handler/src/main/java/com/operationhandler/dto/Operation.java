package com.operationhandler.dto;

import java.math.BigDecimal;
import java.util.Date;

public class Operation {
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
        this.accountSender = accountSender;
        this.accountReceiver = accountReceiver;
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


    public Long getAccountSender() {
        return accountSender;
    }

    public void setAccountSender(Long accountSender) {
        this.accountSender = accountSender;
    }

    public Long getAccountReceiver() {
        return accountReceiver;
    }

    public void setAccountReceiver(Long accountReceiver) {
        this.accountReceiver = accountReceiver;
    }

    @Override
    public String toString() {
        return "Operation{" + "amount=" + amount + ", label='" + label + '\'' + ", creationDate=" + creationDate + ", accountSender='" + accountSender + '\'' + ", accountReceiver='" + accountReceiver + '\'' + '}';
    }
}
