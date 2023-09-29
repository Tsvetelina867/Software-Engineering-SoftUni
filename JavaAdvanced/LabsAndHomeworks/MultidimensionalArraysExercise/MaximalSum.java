package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = tokens[0];
        int cols = tokens[1];
        int[][] matrix = new int[rows][cols];
        readMatrix(matrix, scanner);

        int maxSum = Integer.MIN_VALUE;
        int maxSumRow = 0;
        int maxSumCol = 0;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                int currentSum = 0;
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        currentSum += matrix[x][y];
                    }
                }
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxSumRow = i;
                    maxSumCol = j;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        for (int i = maxSumRow; i < maxSumRow + 3; i++) {
            for (int j = maxSumCol; j < maxSumCol + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }


    private static void readMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
    }
}
