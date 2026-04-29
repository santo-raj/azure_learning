package com.santobank.helloworld.service.impl;

import com.santobank.helloworld.model.Transaction;
import com.santobank.helloworld.service.BankingService;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankingServiceImpl implements BankingService {

    private List<Transaction> transactions = new ArrayList<>();
    private double balance = 0;

    public List<Transaction> getAll() {
        return transactions;
    }

    public double getBalance() {
        return balance;
    }

    public Transaction deposit(double amount, String message) {

        if (amount <= 0) {
            throw new RuntimeException("Invalid deposit amount");
        }

        balance += amount;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZonedDateTime pstTime = LocalDateTime.now().atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("America/Los_Angeles"));

        Transaction t = new Transaction();
        t.dateTime = pstTime.format(formatter);
        t.message = message;
        t.deposit = amount;
        t.withdraw = 0;
        t.total = balance;

        transactions.add(t);
        saveToFile();
        return t;
    }

    public Transaction withdraw(double amount, String message) {

        if (amount <= 0) {
            throw new RuntimeException("Invalid withdraw amount");
        }

        if (amount > balance) {
            throw new RuntimeException("Insufficient balance");
        }

        balance -= amount;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZonedDateTime pstTime = LocalDateTime.now().atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("America/Los_Angeles"));

        Transaction t = new Transaction();
        t.dateTime = pstTime.format(formatter);
        t.message = message;
        t.deposit = 0;
        t.withdraw = amount;
        t.total = balance;

        transactions.add(t);
        saveToFile();
        return t;
    }

    private void saveToFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("transactions.json"), transactions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}