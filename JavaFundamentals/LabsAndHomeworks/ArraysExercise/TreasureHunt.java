package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;


public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] loot = scanner.nextLine().split("\\|");
        String[] treasureChest = Arrays.copyOf(loot, loot.length);
        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")) {
            String[] tokens = command.split("\\s+");
            String action = tokens[0];

            switch (action) {
                case "Loot":
                    for (int i = 1; i < tokens.length; i++) {
                        String newItem = tokens[i];
                        boolean containsItem = false;
                        for (int j = 0; j < treasureChest.length; j++) {
                            if (treasureChest[j].equals(newItem)) {
                                containsItem = true;
                                break;
                            }
                        }
                        if (!containsItem) {
                            treasureChest = insertItemAtBeginning(treasureChest, newItem);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < treasureChest.length) {
                        treasureChest = insertItemAtEnd(treasureChest, treasureChest[index]);
                        treasureChest = removeItemAtPosition(treasureChest, index);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(tokens[1]);
                    if (count >= treasureChest.length) {
                        System.out.println(String.join(", ", treasureChest));
                        treasureChest = new String[0];
                    } else {
                        String[] stolenItems = new String[count];
                        for (int i = 0; i < count; i++) {
                            int lastIndex = treasureChest.length - 1;
                            stolenItems[i] = treasureChest[lastIndex];
                            treasureChest = removeItemAtPosition(treasureChest, lastIndex);
                        }
                        System.out.println(String.join(", ", reverseArray(stolenItems)));
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        if (treasureChest.length == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            int totalItems = treasureChest.length;
            int totalLength = 0;
            for (String item : treasureChest) {
                totalLength += item.length();
            }
            double averageGain = (double) totalLength / totalItems;
            System.out.printf("Average treasure gain: %.2f pirate credits.%n", averageGain);
        }
    }

    private static String[] insertItemAtBeginning(String[] array, String item) {
        String[] newArray = new String[array.length + 1];
        newArray[0] = item;
        System.arraycopy(array, 0, newArray, 1, array.length);
        return newArray;
    }

    private static String[] insertItemAtEnd(String[] array, String item) {
        String[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[newArray.length - 1] = item;
        return newArray;
    }

    private static String[] removeItemAtPosition(String[] array, int position) {
        String[] newArray = new String[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, position);
        System.arraycopy(array, position + 1, newArray, position, array.length - position - 1);
        return newArray;
    }

    private static String[] reverseArray(String[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}