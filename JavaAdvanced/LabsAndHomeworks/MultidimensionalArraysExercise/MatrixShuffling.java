package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = tokens[0];
        int cols = tokens[1];
        String[][] matrix = new String[rows][cols];
        readMatrix(matrix, scanner);
        String line = scanner.nextLine();

        while (!"END".equals(line)) {
            String[] input = line.split("\\s+");
            if (!checkIfCommandIsValid(input)) {
                System.out.println("Invalid input!");
            } else {
                int row1 = Integer.parseInt(input[1]);
                int col1 = Integer.parseInt(input[2]);
                int row2 = Integer.parseInt(input[3]);
                int col2 = Integer.parseInt(input[4]);

                if (!checkIfIndicesAreValid(row1, row2, col1, col2, matrix)) {
                    System.out.println("Invalid input!");
                } else {
                    swapAndPrintMatrix(row1, col1, row2, col2, matrix);
                }
            }
            line = scanner.nextLine();
        }
    }


        private static void swapAndPrintMatrix(int row1, int col1, int row2, int col2, String[][] matrix) {
            String temp = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = temp;

            for (String[] row : matrix) {
                for (String element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        }


    private static boolean checkIfIndicesAreValid(int row1, int row2, int col1, int col2, String[][] matrix) {
        return row1 >= 0 && row1 < matrix.length && row2 >= 0 && row2 < matrix.length
                && col1 >= 0 && col1 < matrix[0].length
                && col2 >= 0 && col2 < matrix[0].length;
    }

    private static boolean checkIfCommandIsValid(String[] input) {
        if (input.length != 5) {
            return false;
        } else if (!input[0].equals("swap")) {
            return false;
        }
        return true;
    }

    private static void readMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            String[] arr = scanner.nextLine().split(" ");
            matrix[i] = arr;
        }
    }
}
