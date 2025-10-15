package org.example.bank;

import java.util.Date;

public class BankTransaction {
    String operation;
    double sum;
    Date time;

    public BankTransaction(String op, double s) {
        operation = op;
        sum = s;
        time = new Date();
    }

    public String toString() {
        return operation + ": " + String.format("%.2f", sum) + " (" + time + ")";
    }
}

