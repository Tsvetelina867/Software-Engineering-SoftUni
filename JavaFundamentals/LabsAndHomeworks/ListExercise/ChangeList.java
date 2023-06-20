package ListExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while(!command.equals("end")) {
            String[] commandTokens = command.split(" ");
            command = commandTokens[0];
            switch (command) {
                case "Delete":
                    int elementToDelete = Integer.parseInt(commandTokens[1]);
                    nums.remove(Integer.valueOf(elementToDelete));
                    break;
                case "Insert":
                    int elementToInsert = Integer.parseInt(commandTokens[1]);
                    int insertIndex = Integer.parseInt(commandTokens[2]);
                    nums.add(insertIndex, elementToInsert);
                    break;
            }
            command = scanner.nextLine();
        }
        for (Integer num : nums) {
            System.out.print(num + " ");
        }

    }
}
