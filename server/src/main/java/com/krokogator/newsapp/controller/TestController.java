package com.krokogator.newsapp.controller;

import com.krokogator.newsapp.model.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "test")
public class TestController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public ResponseEntity<Test> testMethod(){
        Test responseBody = new Test("I am the test!");
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
