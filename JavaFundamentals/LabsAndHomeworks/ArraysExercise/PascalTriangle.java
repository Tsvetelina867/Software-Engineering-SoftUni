package ArraysExercise;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        long[] currentRow = new long[n];
        long[] previousRow = new long[n];

        previousRow[0] = 1;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                long value = (j > 0 ? previousRow[j - 1] : 0) + previousRow[j];
                currentRow[j] = value;
                System.out.print(value + " ");
            }
            System.out.println();

            long[] temp = currentRow;
            currentRow = previousRow;
            previousRow = temp;
        }

    }
}
