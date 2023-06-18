package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while(!command.equals("Finish")) {
            String[] commandTokens = command.split(" ");
            command = commandTokens[0];

            switch (command) {
                case "Add":
                    int valueToAdd = Integer.parseInt(commandTokens[1]);
                    numbers.add(valueToAdd);
                    break;

                case "Remove":
                    int valueToRemove = Integer.parseInt(commandTokens[1]);
                    if (numbers.contains(valueToRemove)) {
                        numbers.remove(Integer.valueOf(valueToRemove));
                    }
                    break;

                case "Replace":
                    int oldValue = Integer.parseInt(commandTokens[1]);
                    int replaceIndex = numbers.indexOf(oldValue);
                    int newValue = Integer.parseInt(commandTokens[2]);
                    if (numbers.contains(oldValue)) {
                        numbers.set(replaceIndex, newValue);
                    }
                    break;

                case "Collapse":
                    int value = Integer.parseInt(commandTokens[1]);
                    numbers.removeIf(number -> number < value);
                    break;
            }
            command = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
