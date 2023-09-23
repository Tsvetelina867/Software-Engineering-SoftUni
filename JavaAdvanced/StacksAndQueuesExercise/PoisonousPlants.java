package StacksAndQueuesExercise;

import java.util.*;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> plants;
        plants = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Stack<Integer> stack = new Stack<>();
        int[] days = new int[n];

        for (int i = 0; i < n; i++) {
            int day = 0;

            while (!stack.isEmpty() && plants.get(i) <= plants.get(stack.peek())) {
                day = Math.max(day, days[stack.pop()]);
            }

            if (!stack.isEmpty()) {
                days[i] = day + 1;
            }

            stack.push(i);
        }

        int maxDays = 0;
        for (int day : days) {
            maxDays = Math.max(maxDays, day);
        }

        System.out.println(maxDays);

    }
}
