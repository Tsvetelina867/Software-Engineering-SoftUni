package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String command = "";
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
             command = scanner.nextLine();
            if (command.contains("1")) {
                String[] input = command.split(" ");
                int number = Integer.parseInt(input[1]);
                stack.push(number);
            } else if (command.equals("2")) {
                    stack.pop();
            } else if (command.equals("3")) {
                System.out.println(Collections.max(stack));
            }
        }
    }
}
