package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = tokens[0];
        int cols = tokens[1];

        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char firstLast = (char) ('a' + i);
                char middle = (char) (firstLast + j);

                System.out.print((char) firstLast);
                System.out.print((char) middle);
                System.out.print((char) firstLast + " ");
            }
            System.out.println();
        }
    }
}
