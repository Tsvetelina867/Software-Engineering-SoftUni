package ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandTokens = command.split(" ");
            command = commandTokens[0].toLowerCase();

            switch (command) {
                case "add":
                    int numberToAdd = Integer.parseInt(commandTokens[1]);
                    nums.add(numberToAdd);
                    break;
                case "insert":
                    int indexToInsert = Integer.parseInt(commandTokens[2]);
                    int numberToInsert = Integer.parseInt(commandTokens[1]);
                    if (checkForInvalidIndex(nums, indexToInsert)) {
                        System.out.println("Invalid index");
                    } else {
                        nums.add(indexToInsert, numberToInsert);
                    }
                    break;
                case "remove":
                    int removeIndex = Integer.parseInt(commandTokens[1]);
                    if (checkForInvalidIndex(nums, removeIndex)) {
                        System.out.println("Invalid index");
                    } else {
                        nums.remove(removeIndex);
                    }
                    break;
                case "shift":
                    String position = commandTokens[1];
                    if (position.equals("left")) {
                        int count = Integer.parseInt(commandTokens[2]);
                        for (int i = 0; i < count; i++) {
                            int firstElement = nums.get(0);
                            for (int j = 1; j < nums.size(); j++) {
                                int currentElement = nums.get(j);
                                nums.set(j - 1, currentElement);
                            }
                            nums.set(nums.size() - 1, firstElement);
                        }
                    } else if (position.equals("right")) {
                        int count = Integer.parseInt(commandTokens[2]);
                        for (int i = 0; i < count; i++) {
                            int lastElement = nums.get(nums.size() - 1);
                            for (int j = nums.size() - 2; j >= 0; j--) {
                                int currentElement = nums.get(j);
                                nums.set(j + 1, currentElement);
                            }
                            nums.set(0, lastElement);
                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }

    public static boolean checkForInvalidIndex(List<Integer> nums, int index) {
        return index < 0 || index >= nums.size();
    }
}
