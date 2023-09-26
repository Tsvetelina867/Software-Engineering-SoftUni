package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(scanner, rows, cols);
        char[][] secondMatrix = readMatrix(scanner, rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char currentSymbol = '*';
                if (firstMatrix[i][j] == secondMatrix[i][j]) {
                    currentSymbol = firstMatrix[i][j];
                }
                System.out.print(currentSymbol + " ");
            }
            System.out.println();
        }

    }

    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            char[] arr = readArray(scanner);

            matrix[i] = arr;
        }
        return matrix;
    }

    private static char[] readArray(Scanner scanner) {
        String input = scanner.nextLine().replaceAll(" ", "");
        return input.toCharArray();
    }
}
