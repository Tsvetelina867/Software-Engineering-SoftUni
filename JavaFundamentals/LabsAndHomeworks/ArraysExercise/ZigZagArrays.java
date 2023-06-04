package ArraysExercise;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        for (int i = 0; i < n; i++) {
            int firstNumber = scanner.nextInt();
            int secondNumber = scanner.nextInt();

            if (i % 2 == 0) {
                firstArray[i] = firstNumber;
                secondArray[i] = secondNumber;
            } else {
                firstArray[i] = secondNumber;
                secondArray[i] = firstNumber;
            }

        }
        for (int i : firstArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : secondArray) {
            System.out.print(i + " ");
        }
    }
}
