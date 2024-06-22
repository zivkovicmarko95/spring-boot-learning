package com.example.spring_event_bus_client.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tests")
public class TestController {
    
    @Autowired
    private Environment environment;

    @GetMapping
    public ResponseEntity<Map<String, String>> testsGet() {

        return new ResponseEntity<>(
                Map.of(
                    "token", this.environment.getProperty("token.secret")
                ),
                HttpStatus.OK
        );
    }

}
