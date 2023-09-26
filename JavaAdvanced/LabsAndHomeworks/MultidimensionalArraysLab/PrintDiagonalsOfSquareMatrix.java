package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }

        for (int rows = 0; rows < matrix.length; rows++) {
                System.out.print(matrix[rows][rows] + " "); //first diagonal
        }
        System.out.println();

        for (int rows = 0; rows < matrix.length; rows++) {
            System.out.print(matrix[matrix.length - 1 - rows][rows] + " ");//second diagonal
        }
    }
}
