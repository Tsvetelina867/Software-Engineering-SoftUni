package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int k = 0; k < rows + cols - 1; k++) {
            int i, j;
            if (k < cols) {
                i = rows - 1;
                j = cols - 1 - k;
            } else {
                i = rows - 2 - (k - cols);
                j = 0;
            }

            StringBuilder diagonal = new StringBuilder();

            while (i >= 0 && j < cols) {
                diagonal.append(matrix[i][j]).append(" ");
                i--;
                j++;
            }

            System.out.println(diagonal.toString().trim());
        }
    }
}
