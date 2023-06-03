package BasicSyntax;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nOfOrders = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0.00;

        while(nOfOrders > 0) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());

            double priceForOrder = ((days * capsulesCount) * pricePerCapsule);
            System.out.printf("The price for the coffee is: $%.2f%n", priceForOrder);

            totalPrice += priceForOrder;
            nOfOrders--;
        }

        System.out.printf("Total: $%.2f", totalPrice);
    }
}
