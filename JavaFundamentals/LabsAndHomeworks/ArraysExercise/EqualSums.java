package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int index = 0; index < array.length; index++) {
            int rightSum = 0;
            int leftSum = 0;
            for (int left = 0; left < index; left++) {
                leftSum += array[left];
            }
            for (int right = index + 1; right < array.length; right++) {
                rightSum += array[right];
            }
            if (leftSum == rightSum) {
                System.out.println(index);
                return;
            }
        }
        System.out.println("no");
    }
}
