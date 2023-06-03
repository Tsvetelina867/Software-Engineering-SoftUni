package DataTypesAndVars;

import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numberA = Double.parseDouble(scanner.nextLine());
        double numberB = Double.parseDouble(scanner.nextLine());
        double eps = 0.000001;
        double difference = Math.abs(numberA - numberB);
        if (difference >= eps) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}
