package org.example.user;

import org.example.bank.BankTransaction;

import java.util.ArrayList;
import java.util.List;

public class UserAccount {
    String name;
    String accId;
    double money;
    double rate;
    List<BankTransaction> history = new ArrayList<>();

    public UserAccount(String id, String n, double r) {
        accId = id;
        name = n;
        rate = r;
        money = 0;
    }

    public boolean addMoney(double a) {
        if (a <= 0) return false;
        money += a;
        history.add(new BankTransaction("Deposit", a));
        return true;
    }

    public boolean takeMoney(double a) {
        if (a <= 0 || a > money) return false;
        money -= a;
        history.add(new BankTransaction("Withdraw", a));
        return true;
    }

    public void printInfo() {
        System.out.println("\n--- Account Info ---");
        System.out.println("Name: " + name);
        System.out.println("ID: " + accId);
        System.out.println("Rate: " + rate + "%");
        System.out.println("Money: " + money);
        System.out.println("\nHistory:");
        if (history.isEmpty()) {
            System.out.println("No history.");
        } else {
            for (BankTransaction t : history) {
                System.out.println(" * " + t);
            }
        }
        System.out.println("---------------------");
    }
}
