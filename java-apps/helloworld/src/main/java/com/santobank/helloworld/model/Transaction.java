package com.santobank.helloworld.model;

import lombok.Data;

@Data
public class Transaction {
    public String dateTime;
    public String message;
    public double deposit;
    public double withdraw;
    public double total;
}
