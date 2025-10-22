package org.example;
import org.example.user.UserAccount;

import java.util.*;

public class Main {
    private static Map<String, UserAccount> users = new HashMap<>();
    public static void AddUser(String id, String name, int x, int y)
    {
        users.put(id, new UserAccount(id, name, x, y));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        users.put("1233", new UserAccount("1233", "Семен", 7.5, 1100));
        for(int i = 0; i < 10; i++) {
            // ID как число в строке: "0", "1", "2"...
            AddUser(String.valueOf(i), "Ivan " + i, i + 1, 1100);
        }
        UserAccount acc = null;
        while (acc == null) {
            System.out.print("Account ID: ");
            String id = in.nextLine();
            if (users.containsKey(id)) {
                acc = users.get(id);
            } else {
                System.out.println("Wrong ID.");
            }
        }

        boolean run = true;
        while (run) {
            System.out.println("\n[1] Add money");
            System.out.println("[2] Take money");
            System.out.println("[3] Show info");
            System.out.println("[4] Exit");
            System.out.print("Select: ");
            String opt = in.nextLine();

            switch (opt) {
                case "1":
                    System.out.print("Sum: ");
                    double dep = Double.parseDouble(in.nextLine());
                    if (!acc.addMoney(dep)) System.out.println("Wrong sum.");
                    break;
                case "2":
                    System.out.print("Sum: ");
                    double wd = Double.parseDouble(in.nextLine());
                    if (!acc.takeMoney(wd)) System.out.println("Wrong sum or not enough money.");
                    break;
                case "3":
                    acc.printInfo();
                    break;
                case "4":
                    System.out.println("Bye.");
                    run = false;
                    break;
                default:
                    System.out.println("Wrong option.");
            }
        }
    }
}
