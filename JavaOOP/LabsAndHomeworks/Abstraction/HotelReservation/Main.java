package Abstraction.HotelReservation;

import Abstraction.HotelReservation.DiscountType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(tokens[0]);
        int numberOfDays = Integer.parseInt(tokens[1]);
        Season season = Season.valueOf((tokens[2]).toUpperCase());
        DiscountType discountType = DiscountType.fromString((tokens[3]));

        PriceCalculator calculator = new PriceCalculator(pricePerDay, numberOfDays, season, discountType);
        System.out.printf("%.2f", calculator.calculatePrice());
    }
}
