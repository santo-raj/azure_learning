package com.santobank.helloworld.service;

import com.santobank.helloworld.model.Transaction;

import java.util.List;

public interface BankingService {

    public List<Transaction> getAll();
    public double getBalance();
    public Transaction deposit(double amount, String message);
    public Transaction withdraw(double amount, String message);
}
