package ListExercise;

import java.util.Arrays;
import java.util.Scanner;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        double firstDriver = 0;
        double secondDriver = 0;

        for (int i = 0; i < nums.length / 2; i++) {
            firstDriver += nums[i];
            if (nums[i] == 0) {
                firstDriver *= 0.8;
            }
        }

        for (int i = nums.length - 1; i > nums.length / 2; i--) {
            secondDriver += nums[i];
            if (nums[i] == 0) {
                secondDriver *= 0.8;
            }
        }

        if (firstDriver < secondDriver) {
            System.out.printf("The winner is left with total time: %.1f", firstDriver);
        } else {
            System.out.printf("The winner is right with total time: %.1f", secondDriver);
        }
    }
}
