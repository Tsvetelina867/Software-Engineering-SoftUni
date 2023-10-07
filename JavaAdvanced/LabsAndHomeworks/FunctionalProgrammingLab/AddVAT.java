package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        UnaryOperator<Double> addVat = value -> value *  1.2;
        System.out.println("Prices with VAT: ");
        Arrays.stream(numbers).forEach(n -> {
            double priceWithVat = addVat.apply(n);
            System.out.printf("%.2f%n", priceWithVat);
        });
    }
}
