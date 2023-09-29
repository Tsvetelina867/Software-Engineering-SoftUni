package MultidimensionalArraysExercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");
        int n = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];

        if ("A".equals(pattern))  {
            fillPatternA(n);
        } else if ("B".equals(pattern)) {
            fillPatternB(n);
        }

    }

    private static void fillPatternB(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j++) {
                    matrix[j][i] = count;
                    count++;
                }
            } else {
                for (int j = cols - 1; j >= 0 ; j--) {
                    matrix[j][i] = count;
                    count++;
                }
            }

        }

        printMatrix(rows, cols, matrix);
    }

    private static void fillPatternA(int size) {
        int[][] matrix = new int[size][size];
        int count = 1;
        int rows = matrix.length;;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[j][i] = count;
                count++;
            }
        }

        printMatrix(rows, cols, matrix);
    }

    private static void printMatrix(int rows, int cols, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
