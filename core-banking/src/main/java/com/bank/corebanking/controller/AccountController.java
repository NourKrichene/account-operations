package com.bank.corebanking.controller;


import com.bank.corebanking.entity.Account;
import com.bank.corebanking.entity.Operation;
import com.bank.corebanking.repository.AccountRepository;
import com.bank.corebanking.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @CrossOrigin
    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAccounts() {
        return new ResponseEntity<>(accountRepository.findAll() , HttpStatus.OK);
    }

}
