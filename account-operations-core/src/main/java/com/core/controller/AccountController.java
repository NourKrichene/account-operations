package com.core.controller;


import com.core.entity.Account;
import com.core.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
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


    @CrossOrigin
    @PostMapping(value = "/add-account")
    public ResponseEntity<String> addAccount(@RequestBody Account account) throws IOException {
        return new ResponseEntity<>("Account added" , HttpStatus.OK);
    }

}
