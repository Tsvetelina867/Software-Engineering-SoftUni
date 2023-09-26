package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixSize = readArray(scanner);
        int[][]matrix = readMatrix(scanner, matrixSize);
        int sum = 0;

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }

        System.out.println(matrixSize[0]);
        System.out.println(matrixSize[1]);
        System.out.println(sum);
    }
    private static int[][] readMatrix(Scanner scanner, int[] matrixSize) {
        int rows = matrixSize[0];
        int cols = matrixSize[1];

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int[] arr = readArray(scanner);

            matrix[i] = arr;
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
    }
}
