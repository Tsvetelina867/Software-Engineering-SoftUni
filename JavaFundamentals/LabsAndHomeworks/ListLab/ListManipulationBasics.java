package ListLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] commandTokens = command.split(" ");
            command = commandTokens[0];

            switch(command) {
                case "Add":
                int numToAdd = Integer.parseInt(commandTokens[1]);
                numbers.add(numToAdd);
                    break;
                case "Remove":
                int numToRemove = Integer.parseInt(commandTokens[1]);
                numbers.remove(Integer.valueOf(numToRemove));
                    break;
                case "RemoveAt":
                int removeIndex = Integer.parseInt(commandTokens[1]);
                numbers.remove(removeIndex);
                    break;
                case "Insert":
                int numberToInsert = Integer.parseInt(commandTokens[1]);
                int insertIndex = Integer.parseInt(commandTokens[2]);
                numbers.add(insertIndex, numberToInsert);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
