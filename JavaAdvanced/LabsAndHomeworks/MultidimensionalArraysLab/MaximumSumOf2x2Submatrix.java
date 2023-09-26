package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        int biggestSum = 0;
        List<int[]> biggestMatrix = new ArrayList<>();
        int[] arr1 = new int[2];
        int[] arr2 = new int[2];

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                int sum = 0;
                int currentElement = matrix[i][j];
                int rightElement = matrix[i][j + 1];
                int belowElement = matrix[i + 1][j];
                int rightBelowElement = matrix[i + 1][j + 1];
                sum = currentElement + rightElement + belowElement + rightBelowElement;

                if (sum > biggestSum) {
                    biggestSum = sum;

                    arr1[0] = currentElement;
                    arr1[1] = rightElement;
                    arr2[0] = belowElement;
                    arr2[1] = rightBelowElement;
                }
            }

        }
        biggestMatrix.add(arr1);
        biggestMatrix.add(arr2);
        for (int[] ints : biggestMatrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        System.out.println(biggestSum);

    }
}
