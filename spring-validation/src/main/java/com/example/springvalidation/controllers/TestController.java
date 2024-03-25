package com.example.springvalidation.controllers;

import com.example.springvalidation.transferobjects.TestTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tests")
public class TestController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @PostMapping
    public ResponseEntity<Void> testsPost(@RequestBody @Validated final TestTO requestBody) {

        LOGGER.info("Parsed request is {}", requestBody);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
