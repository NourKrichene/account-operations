package com.bank.corebanking.entity;

public class Notification {

    Operation operation;
    Account sender;
    Account receiver;

    public Operation getOperation() {
        return operation;
    }

    public Account getSender() {
        return sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }
}
