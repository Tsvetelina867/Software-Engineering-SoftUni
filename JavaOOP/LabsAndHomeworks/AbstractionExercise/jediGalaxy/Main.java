package AbstractionExercise.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner.nextLine());
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value++;
            }
        }

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediCoordinates = readArray(command);
            int[] evilCoordinates = readArray(scanner.nextLine());
            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];

            moveEvil(evilRow, evilCol, matrix);

            int jediRow = jediCoordinates[0];
            int jediCol = jediCoordinates[1];

            sum = collectStars(jediRow, jediCol, matrix, sum);

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static long collectStars(int jediRow, int jediCol, int[][] matrix, long sum) {
        while (jediRow >= 0 && jediCol < matrix[1].length) {
            if (jediRow < matrix.length && jediCol >= 0 && jediCol < matrix[0].length) {
                sum += matrix[jediRow][jediCol];
            }

            jediCol++;
            jediRow--;
        }
        return sum;
    }

    private static void moveEvil(int evilRow, int evilCol, int[][] matrix) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < matrix.length && evilCol < matrix[0].length) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static int[] readArray(String command) {
        return Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
