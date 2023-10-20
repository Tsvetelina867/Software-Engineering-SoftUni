package ExamPreparation;

import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[8][8];

        int wRow = -1;
        int wCol = -1;
        int bRow = -1;
        int bCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            char[] arr = scanner.nextLine().toCharArray();
            for (int col = 0; col < arr.length; col++) {
                matrix[row][col] = arr[col];
                if (arr[col] == 'w') {
                    wRow = row;
                    wCol = col;
                } else if (arr[col] == 'b') {
                    bRow = row;
                    bCol = col;
                }
            }
        }

        boolean isHit = false;

        while (wRow != 0 && bRow != 7 && !isHit) {
            if (checkIfDiagonalsInteract(wRow, wCol, bRow, bCol)) {
                String coordinates = findCoordinates(bRow, bCol);
                System.out.printf("Game over! White capture on %s.", coordinates);
                isHit = true;
            }
            wRow -= 1;

            if (checkIfDiagonalsInteract(bRow, bCol, wRow, wCol)) {
                String coordinates = findCoordinates(wRow, wCol);
                System.out.printf("Game over! Black capture on %s.", coordinates);
                isHit = true;
            }
            bRow += 1;
        }

        if (!isHit) {
            System.out.print(wRow == 0
                    ? "Game over! White pawn is promoted to a queen at " + findCoordinates(wRow, wCol) + "."
                    : "Game over! Black pawn is promoted to a queen at " + findCoordinates(bRow, bCol) + "."
            );
        }
    }

    private static String findCoordinates(int row, int col) {
        char[] colChars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] rowChars = {'8', '7', '6', '5', '4', '3', '2', '1'};
        return String.valueOf(colChars[col]) + rowChars[row];
    }

    private static boolean checkIfDiagonalsInteract(int row1, int col1, int row2, int col2) {
        return Math.abs(row1 - row2) == 1 && Math.abs(col1 - col2) == 1;
    }
}