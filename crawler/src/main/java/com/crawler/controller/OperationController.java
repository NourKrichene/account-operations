package com.crawler.controller;


import com.crawler.service.IIndexingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OperationController {


    private IIndexingService indexingService;

    @Autowired
    public OperationController(IIndexingService indexingService) {
        this.indexingService = indexingService;
    }

    @CrossOrigin
    @GetMapping("/save")
    public ResponseEntity<String> saveOperations() {
        indexingService.saveOperation();
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/get")
    public ResponseEntity<String> getOperations() {
        indexingService.serachOperation();
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

}
