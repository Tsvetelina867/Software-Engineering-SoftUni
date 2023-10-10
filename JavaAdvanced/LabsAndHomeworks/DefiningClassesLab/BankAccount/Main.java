package DefiningClassesLab.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        Map<Integer, BankAccount> bank = new HashMap<>();
        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            if (command.equals("Create")) {
                BankAccount account = new BankAccount();
                bank.put(account.getId(), account);
                System.out.printf("Account ID%d created%n", account.getId());
            } else if (command.equals("Deposit")) {
                int id = Integer.parseInt(tokens[1]);
                if (!bank.containsKey(id)) {
                    System.out.println("Account does not exist");
                } else {
                    int amount = Integer.parseInt(tokens[2]);
                    bank.get(id).deposit(amount);
                    System.out.println("Deposited " + amount + " to ID" + id);
                }
            } else if (command.equals("SetInterest")) {
                double interest = Double.parseDouble(tokens[1]);
                BankAccount.setInterestRate(interest);
            } else if (command.equals("GetInterest")) {
                int id = Integer.parseInt(tokens[1]);
                if (!bank.containsKey(id)) {
                    System.out.println("Account does not exist");
                } else {
                    int years = Integer.parseInt(tokens[2]);
                    BankAccount account = bank.get(id);
                    System.out.printf("%.2f%n", account.getInterest(years));
                }
            }

            line = sc.nextLine();
        }
    }
}
