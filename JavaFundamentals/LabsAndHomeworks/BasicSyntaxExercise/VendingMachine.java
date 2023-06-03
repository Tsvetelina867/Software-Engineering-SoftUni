package BasicSyntax;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sum = 0.00;
        double nutsPrice = 2.0;
        double waterPrice = 0.7;
        double crispsPrice = 1.5;
        double sodaPrice = 0.8;
        double cokePrice = 1.0;

        while (!input.equals("Start")) {
            double coins = Double.parseDouble(input);
            if (coins ==  0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2) {
                sum += coins;
            } else {
                System.out.printf("Cannot accept %.2f%n", coins);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("End")) {
            switch (input) {
                case "Nuts":
                    if (sum < nutsPrice) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.println("Purchased Nuts");
                        sum -= nutsPrice;
                    }
                    break;
                case "Water":
                    if (sum < waterPrice) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.println("Purchased Water");
                        sum -= waterPrice;
                    }
                    break;
                case "Crisps":
                    if (sum < crispsPrice) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.println("Purchased Crisps");
                        sum -= crispsPrice;
                    }
                    break;
                case "Soda":
                    if (sum < sodaPrice) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.println("Purchased Soda");
                        sum -= sodaPrice;
                    }
                    break;
                case "Coke":
                    if (sum < cokePrice) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.println("Purchased Coke");
                        sum -= cokePrice;
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            input = scanner.nextLine();
        }
        double change = sum;
        System.out.printf("Change: %.2f", change);
    }
}
