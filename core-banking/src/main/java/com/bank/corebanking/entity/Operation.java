package com.bank.corebanking.entity;

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
    Date executionDate;
    boolean withdrawal;

    public Operation() {
    }

    public Operation(BigDecimal amount , String label , Date executionDate , boolean withdrawal) {
        this.amount = amount;
        this.label = label;
        this.executionDate = executionDate;
        this.withdrawal = withdrawal;
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

    @Override
    public String toString() {
        return "Operation{" + "id=" + id + ", amount=" + amount + ", label='" + label + '\'' + ", executionDate=" + executionDate + ", withdrawal=" + withdrawal + '}';
    }
}
