package org.example.bank;

import java.util.Date;

public class BankTransaction {
    double amount;
    double balance;
    Date time;
    char type;
    String description;

    public BankTransaction(char type, double amount, double balance, String description) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
        time = new Date();
    }

    public String toString() {
        return "(" + time + ") " + "[ " + type + " ]" + " Amount: " + String.format("%.2f", amount) + "; balance: " + String.format("%.2f", balance) + "; desc: " + description;
    }
}

