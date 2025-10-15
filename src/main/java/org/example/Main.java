package org.example;
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
        System.out.println("\n===== Сводка аккаунта =====");
        System.out.println("Владелец: " + ownerName);
        System.out.println("Аккаунт ID: " + id);
        System.out.println("Balance: " + balance);
        System.out.println("\nПереводы:");
        if (transactions.isEmpty()) {
            System.out.println("Пока переводов нет.");
        } else {
            for (Transaction t : transactions) {
                System.out.println(" - " + t);
            }
        }
        System.out.println("");
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello KIPFIN!");
        System.out.println("Hello KIPFIN!");
        System.out.println("Hello KIPFIN!");
        System.out.println("Hello KIPFIN!");
    }
}