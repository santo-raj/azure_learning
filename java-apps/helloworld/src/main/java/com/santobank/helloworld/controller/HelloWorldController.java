package com.santobank.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public Map<String, String> hello() {
        System.out.println("Request inside");
        return Map.of("message", "Hello from Azure Banking App 🚀");
    }
}