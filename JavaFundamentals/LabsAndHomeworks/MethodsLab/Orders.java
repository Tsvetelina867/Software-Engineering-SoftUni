package MethodsLab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        getReceipt(product, quantity);
    }

    public static void getReceipt(String product, int quantity) {
        double total = 0.00;
        switch (product) {
            case "coffee":
                total = 1.50 * quantity;
                break;
            case "water":
                total = 1.00 * quantity;
                break;
            case "coke":
                total = 1.40 * quantity;
                break;
            case "snacks":
                total = 2.00 * quantity;
                break;
        }
        System.out.printf("%.2f", total);
    }
}
