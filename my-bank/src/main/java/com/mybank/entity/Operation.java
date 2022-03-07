package com.mybank.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Operation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int amount;
    String label;
    Date executionDate;

    public Operation() { }

    public Long getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getLabel() {
        return label;
    }

    public Date getExecutionDate() {
        return executionDate;
    }
}
