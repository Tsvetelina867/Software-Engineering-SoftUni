package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] train = new int[n];
        int sumOfPeople = 0;

        for (int i = 0; i < n; i++) {
            train[i] = Integer.parseInt(scanner.nextLine());
            sumOfPeople += train[i];
        }

        for (int i : train) {
            System.out.print(i + " ");

        }
        System.out.println();
        System.out.println(sumOfPeople);
    }
}
