package ListLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
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
                case "Contains":
                    int numToCheck = Integer.parseInt(commandTokens[1]);
                    if (numbers.contains(numToCheck)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    String evenOrOdd = commandTokens[1];
                    if (evenOrOdd.equals("even")) {
                        printEvenNumbers(numbers);
                    } else {
                        printOddNumbers(numbers);
                    }
                    break;
                case "Get":
                    printSum(numbers);
                    break;
                case "Filter":
                    String condition = commandTokens[1];
                    int number = Integer.parseInt(commandTokens[2]);
                    filterNumbers(numbers, condition, number);
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }

    }

    public static void printEvenNumbers(List<Integer> number) {
        for (Integer integer : number) {
            if (integer % 2 == 0) {
                System.out.print(integer + " ");
            }
        }
        System.out.println();
    }
    public static void printOddNumbers(List<Integer> number) {
        for (Integer integer : number) {
            if (integer % 2 != 0) {
                System.out.print(integer + " ");
            }
        }
        System.out.println();
    }

    public static void printSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }

    public static void filterNumbers(List<Integer> numbers, String condition, int num) {
        for (Integer number : numbers) {
            switch (condition) {
                case ">":
                    if (number > num) {
                        System.out.print(number + " ");
                    }
                    break;
                case "<":
                    if (number < num) {
                        System.out.print(number + " ");
                    }
                    break;
                case ">=":
                    if (number >= num) {
                        System.out.print(number + " ");
                    }
                    break;
                case "<=":
                    if (number <= num) {
                        System.out.print(number + " ");
                    }
                    break;
            }
        }


    }
}
