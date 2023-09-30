package SetsAndMapsLab;

import javax.swing.*;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> parking = new LinkedHashSet<>();

        while (!"END".equals(input)) {
            String[] inputTokens = input.split(", ");
            String direction = inputTokens[0];
            String plateNumber = inputTokens[1];

            if (direction.equals("IN")) {
                parking.add(plateNumber);
            } else {
                parking.remove(plateNumber);
            }

            input = scanner.nextLine();
        }
        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parking) {
                System.out.println(car);
            }
        }
    }
}
