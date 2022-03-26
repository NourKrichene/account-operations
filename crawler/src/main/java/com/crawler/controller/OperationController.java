package com.crawler.controller;


import com.crawler.entity.Operation;
import com.crawler.service.IIndexingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OperationController {

    private IIndexingService indexingService;

    @Autowired
    public OperationController(IIndexingService indexingService) {
        this.indexingService = indexingService;
    }


    @CrossOrigin
    @GetMapping("/operation/search")
    public ResponseEntity<String> getOperations() {
        indexingService.searchOperation();
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/operation/add")
    public ResponseEntity<String> createOrUpdateAccount(@RequestBody Operation operation) {
        indexingService.indexOperation(operation);
        return new ResponseEntity<>("Operation indexed", HttpStatus.OK);
    }
}