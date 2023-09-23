package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        int numbersToPush = Integer.parseInt(tokens[0]);
        int numbersToRemove = Integer.parseInt(tokens[1]);
        int numberToCheck = Integer.parseInt(tokens[2]);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> numbersQueue = new ArrayDeque<>();


        for (int i = 0; i < numbersToPush; i++) {
            int element = Integer.parseInt(input[i]);
            numbersQueue.offer(element);
        }
        for (int i = 0; i < numbersToRemove; i++) {
            numbersQueue.poll();
        }

        if (numbersQueue.isEmpty()) {
            System.out.println(0);
        } else if (numbersQueue.contains(numberToCheck)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(numbersQueue));
        }


    }
}
