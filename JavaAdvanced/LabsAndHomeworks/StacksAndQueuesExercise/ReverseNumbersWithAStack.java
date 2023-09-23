package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int num : nums) {
            numbers.push(num);
        }

        while(!numbers.isEmpty()) {
            System.out.print(numbers.pop() + " ");
        }
    }
}
