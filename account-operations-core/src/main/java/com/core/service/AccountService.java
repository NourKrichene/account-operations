package com.core.service;

import com.core.model.Operation;
import com.core.model.OperationNotification;
import com.core.repository.AccountRepository;
import com.core.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AccountService {


    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private AccountRepository accountRepository;


    public OperationNotification executeOperation(Operation operation) {
        OperationNotification notification = new OperationNotification();
        operation.setCreationDate(new Date());
        if (operation.getAccountReceiver() != null) {
            updateReceiverAccount(operation, notification);
        }
        if (operation.getAccountSender() != null) updateSenderAccount(operation, notification);
        operationRepository.save(operation);
        notification.setOperation(operation);
        return notification;
    }

    @Transactional
    private void updateReceiverAccount(Operation operation, OperationNotification notification) {
        var receiver = accountRepository.findById(operation.getAccountReceiver());
        receiver.ifPresent(e -> {
                    e.setBalance(e.getBalance().add(operation.getAmount()));
                    accountRepository.save(e);
                    notification.setReceiver(e);
                }
        );
    }

    @Transactional
    private void updateSenderAccount(Operation operation, OperationNotification notification) {
        var sender = accountRepository.findById(operation.getAccountSender());
        sender.ifPresent(e -> {
                    e.setBalance(e.getBalance().subtract(operation.getAmount()));
                    accountRepository.save(e);
                    notification.setSender(e);
                }
        );
    }
}
