package TextProcessingExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input;

        while (!(input = scanner.nextLine()).equals("find")) {
            StringBuilder decryptedMesage = new StringBuilder();
            int keyCounter = 0;
            for (int i = 0; i < input.length(); i++) {
                char currentSymbol = input.charAt(i);
                if (keyCounter > nums.length - 1) {
                    keyCounter = 0;
                }
                int key = nums[keyCounter];
                keyCounter++;
                int newValue = currentSymbol - key;
                currentSymbol = (char) newValue;
                decryptedMesage.append(currentSymbol);
            }
            String type = decryptedMesage.substring(decryptedMesage.indexOf("&") + 1, decryptedMesage.lastIndexOf("&"));
            String coordinates = decryptedMesage.substring(decryptedMesage.indexOf("<") + 1, decryptedMesage.indexOf(">"));
            System.out.printf("Found %s at %s%n", type, coordinates);
        }
    }
}
