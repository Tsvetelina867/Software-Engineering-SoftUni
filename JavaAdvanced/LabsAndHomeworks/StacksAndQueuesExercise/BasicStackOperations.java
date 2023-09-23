package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        int numbersToPush = Integer.parseInt(tokens[0]);
        int numbersToPop = Integer.parseInt(tokens[1]);
        int numberToCheck = Integer.parseInt(tokens[2]);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();
        ArrayDeque<Integer> minStack = new ArrayDeque<>();

        for (int i = 0; i < numbersToPush; i++) {
           int element = Integer.parseInt(input[i]);
            numbersStack.push(element);
        }
        for (int i = 0; i < numbersToPop; i++) {
            numbersStack.pop();
        }

        if (numbersStack.isEmpty()) {
            System.out.println(0);
            return;
        }
        for (Integer i : numbersStack) {
            if (i == numberToCheck) {
                System.out.println("true");
                return;
            }
        }

        minStack.push(numbersStack.peek());
        for (Integer i : numbersStack) {
            if (i < minStack.getFirst()) {
                    minStack.pop();
                    minStack.push(i);
            }
        }
        System.out.println(minStack.peek());

    }
}
