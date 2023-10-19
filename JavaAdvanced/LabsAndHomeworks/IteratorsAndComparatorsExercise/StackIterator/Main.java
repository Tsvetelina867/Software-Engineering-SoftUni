package IteratorsAndComparatorsExercise.StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack stack = new Stack();
        String line = scanner.nextLine();
        while (!line.equals("END")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            if (command.equals("Push")) {
                Arrays.stream(line.split("[\\s,]+"))
                        .skip(1)
                        .map(Integer::parseInt)
                        .forEach(stack::push);
            } else if (command.equals("Pop")) {
                try {
                    stack.pop();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            }
            line = scanner.nextLine();
        }

        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}
