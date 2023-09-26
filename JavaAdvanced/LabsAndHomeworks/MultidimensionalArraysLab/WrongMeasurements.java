package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        int[] wrongValueSize = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int wrongRow = wrongValueSize[0];
        int wrongCol = wrongValueSize[1];
        int wrongValue = matrix[wrongRow][wrongCol];

        for (int r = 0; r < matrix.length; r++) {
            int sum = 0;
            for (int c = 0; c < matrix[0].length; c++) {

                if (matrix[r][c] == wrongValue) {
                    if (isInBounds(matrix, r - 1, c) && matrix[r - 1][c] != wrongValue) { //top
                        sum += matrix[r - 1][c];
                    }
                    if (isInBounds(matrix, r + 1, c) && matrix[r + 1][c] != wrongValue) { //down
                        sum += matrix[r + 1][c];
                    }
                    if (isInBounds(matrix, r, c -1) && matrix[r][c - 1] != wrongValue) { //left
                        sum += matrix[r][c - 1];
                    }
                    if (isInBounds(matrix, r, c + 1) && matrix[r][c + 1] != wrongValue) { //right
                        sum += matrix[r][c + 1];
                    }
                    System.out.print(sum + " ");
                } else {
                    System.out.print(matrix[r][c] + " ");
                }
            }
            System.out.println();
        }
    }

    private static boolean isInBounds (int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length &&
                c >= 0 && c < matrix[r].length;
    }
}
