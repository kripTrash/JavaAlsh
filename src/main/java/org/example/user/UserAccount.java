package org.example.user;

import org.example.bank.BankTransaction;
import org.example.fileio.FileInput;
import org.example.fileio.FileOutput;

import java.util.List;

public class UserAccount {
    private final String nameFile = "transactions.txt";
    String name;
    String accId;
    double money;
    double rate;

    public UserAccount(String id, String n, double r, double m) {
        accId = id;
        name = n;
        rate = r;
        money = m;
    }

    public boolean addMoney(double a) {
        if (a <= 0) return false;
        money += a;
        var transaction = new BankTransaction('+', a, money, String.format("Add money for %s", name));
        boolean check = FileInput.writeFile(nameFile, transaction.toString());
        if (!check) {
            System.out.println("Не удалось записать данные в файл.");
        }
        return true;
    }

    public boolean takeMoney(double a) {
        if (a <= 0 || a > money) return false;
        money -= a;
        var transaction = new BankTransaction('-', a, money, String.format("Take money for %s", name));

        boolean check = FileInput.writeFile(nameFile, transaction.toString());
        if (!check) {
            System.out.println("Не удалось записать данные в файл.");
        }
        return true;
    }

    public void printInfo() {
        System.out.println("\n--- Account Info ---");
        System.out.println("Name: " + name);
        System.out.println("ID: " + accId);
        System.out.println("Rate: " + rate + "%");
        System.out.println("Money: " + money + "руб.");
        System.out.println("\nHistory:");

        List<String> transactions = FileOutput.readFile(nameFile);
        if (transactions.isEmpty()) {
            System.out.println("История не найдена.");
        }
        else {
            for (String t : transactions) {
                System.out.println(" * " + t);
            }
        }
        System.out.println("---------------------");
    }
}
