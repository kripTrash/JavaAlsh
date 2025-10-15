package org.example;

import java.util.*;

class Transaction {
    private String type;
    private double amount;
    private Date date;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f (%s)", type, amount, date.toString());
    }
}

class BankAccount {
    private String ownerName;
    private String id;
    private double balance;
    private double interestRate;
    private List<Transaction> transactions = new ArrayList<>();

    public BankAccount(String id, String ownerName, double interestRate) {
        this.id = id;
        this.ownerName = ownerName;
        this.interestRate = interestRate;
        this.balance = 0;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        transactions.add(new Transaction("Withdraw", amount));
        return true;
    }

    public void showSummary() {
        System.out.println("\n===== Account Summary =====");
        System.out.println("Owner: " + ownerName);
        System.out.println("Account ID: " + id);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Balance: " + balance);
        System.out.println("\nTransactions:");
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (Transaction t : transactions) {
                System.out.println(" - " + t);
            }
        }
        System.out.println("============================");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, BankAccount> accounts = new HashMap<>();
        accounts.put("123", new BankAccount("123", "Riot", 2.5));
        accounts.put("999", new BankAccount("999", "Ivan Ivanov", 3.0));

        BankAccount account = null;
        while (account == null) {
            System.out.print("Enter account ID: ");
            String id = sc.nextLine();
            if (accounts.containsKey(id)) {
                account = accounts.get(id);
            } else {
                System.out.println("Invalid ID. Try again.");
            }
        }

        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show summary");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter amount: ");
                    double dep = Double.parseDouble(sc.nextLine());
                    if (!account.deposit(dep)) System.out.println("Invalid amount.");
                    break;
                case "2":
                    System.out.print("Enter amount: ");
                    double wd = Double.parseDouble(sc.nextLine());
                    if (!account.withdraw(wd)) System.out.println("Invalid amount or insufficient funds.");
                    break;
                case "3":
                    account.showSummary();
                    break;
                case "4":
                    System.out.println("Goodbye.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}