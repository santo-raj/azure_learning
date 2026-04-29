package com.santobank.helloworld.controller;

import com.santobank.helloworld.model.Transaction;
import com.santobank.helloworld.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BankingController {

    @Autowired
    private LoginController loginController;

    @Autowired
    private BankingService service;

    @GetMapping("/balance")
    public double balance() {
        checkAuth();
        return service.getBalance();
    }

    @GetMapping("/transactions")
    public List<Transaction> transactions() {
        return service.getAll();
    }

    @PostMapping("/deposit")
    public Transaction deposit(@RequestParam double amount,
                               @RequestParam String message) {
        return service.deposit(amount, message);
    }

    @PostMapping("/withdraw")
    public Transaction withdraw(@RequestParam double amount,
                                @RequestParam String message) {
        return service.withdraw(amount, message);
    }

    private void checkAuth() {
        if (!loginController.status()) {
            throw new RuntimeException("Unauthorized");
        }
    }
}