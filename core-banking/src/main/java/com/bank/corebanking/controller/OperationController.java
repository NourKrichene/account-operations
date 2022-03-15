package com.bank.corebanking.controller;


import com.bank.corebanking.entity.Operation;
import com.bank.corebanking.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OperationController {

    @Autowired
    private OperationRepository operationRepository;

    @CrossOrigin
    @GetMapping("/operations")
    public ResponseEntity<List<Operation>> getOperations() {
        return new ResponseEntity<>(operationRepository.findAll() , HttpStatus.OK);
    }

}
