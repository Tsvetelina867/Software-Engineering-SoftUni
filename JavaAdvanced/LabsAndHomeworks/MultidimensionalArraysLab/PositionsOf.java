package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        int neededNum = Integer.parseInt(scanner.nextLine());
        List<int[]> positions = new ArrayList<>();
        boolean isFound = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == neededNum) {
                    int[] pos = new int[2];
                    pos[0] = i;
                    pos[1] = j;
                    positions.add(pos);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }

        for (int[] position : positions) {
            for (int i : position) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] matrixSize = readArray(scanner);
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
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
