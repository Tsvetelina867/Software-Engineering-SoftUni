package MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] places = Arrays.stream(scanner.nextLine().split("@")).mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();
        int currentPlace = 0;

        while(!command.equals("Love!")) {
            String[] commandTokens = command.split(" ");
            int index = Integer.parseInt(commandTokens[1]);
            currentPlace += index;
            if (currentPlace > places.length - 1) {
                currentPlace = 0;
            }
            if (places[currentPlace] == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", currentPlace);
            } else {
                places[currentPlace] -= 2;
                if (places[currentPlace] == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", currentPlace);
                }
            }
            command = scanner.nextLine();
        }
        int failedCount = 0;

        System.out.printf("Cupid's last position was %d.%n", currentPlace);
        for (int place : places) {
            if (place != 0) {
                failedCount++;
            }
        }

        if (failedCount > 0) {
            System.out.printf("Cupid has failed %d places.%n", failedCount);
        } else {
            System.out.println("Mission was successful.");
        }
    }
}
