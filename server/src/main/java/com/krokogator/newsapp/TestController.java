package com.krokogator.newsapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "test")
public class TestController {

    @GetMapping()
    public ResponseEntity<String> testMethod(){
        return new ResponseEntity<>("I'm the test method", HttpStatus.OK);
    }
}
