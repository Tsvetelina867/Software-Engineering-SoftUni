package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        matrix = readMatrix(matrix, scanner);
        int sum = Math.abs(getPrimaryDiagonalSum(matrix) - getSecondaryDiagonalSum(matrix));
        System.out.println(sum);

    }

    private static int getSecondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        int counter = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            sum += matrix[i][counter];
            counter++;
        }
        return sum;
    }

    private static int getPrimaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int[][] readMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
                int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                matrix[i] = arr;
        }
        return matrix;
    }
}
