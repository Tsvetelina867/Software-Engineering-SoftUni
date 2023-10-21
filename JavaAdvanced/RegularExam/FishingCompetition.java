package RegularExam;

import java.util.Scanner;

public class FishingCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] area = new char[n][n];

        int currentRow = 0;
        int currentCol = 0;

        for (int row = 0; row < n; row++) {
            char[] arr = scanner.nextLine().toCharArray();
            for (int col = 0; col < n; col++) {
                area[row][col] = arr[col];
                if (arr[col] == 'S') {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }

        int caughtFish = 0;
        String command = scanner.nextLine();
        while (!command.equals("collect the nets")) {
            area[currentRow][currentCol] = '-';

            switch (command) {
                case "up":
                    if(isInBoundaries(area, currentRow - 1, currentCol)) {
                        currentRow--;
                    } else {
                        currentRow = area.length - 1;
                    }
                    break;
                case "down":
                    if(isInBoundaries(area, currentRow + 1, currentCol)) {
                        currentRow++;
                    } else {
                        currentRow = 0;
                    }
                    break;
                case "left":
                    if(isInBoundaries(area, currentRow, currentCol - 1)) {
                        currentCol--;
                    } else {
                        currentCol = area[currentRow].length - 1;
                    }
                    break;
                case "right":
                    if(isInBoundaries(area, currentRow, currentCol + 1)) {
                        currentCol++;
                    } else {
                        currentCol = 0;
                    }
                    break;
            }
            if (area[currentRow][currentCol] == '-') {
                area[currentRow][currentCol] = 'S';
            } else if (area[currentRow][currentCol] == 'W') {
                System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]%n", currentRow, currentCol);
                return;
            } else if (Character.isDigit(area[currentRow][currentCol])) {
                int fish = area[currentRow][currentCol] - '0';
                area[currentRow][currentCol] = 'S';
                caughtFish += fish;
            }

            command = scanner.nextLine();
        }
        if (caughtFish >= 20) {
            System.out.println("Success! You managed to reach the quota!");
            System.out.println("Amount of fish caught: " + caughtFish + " tons.");
        } else if (caughtFish > 0 && caughtFish < 20){
            int neededFish = 20 - caughtFish;
            System.out.println("You didn't catch enough fish and didn't reach the quota! You need " + neededFish + " tons of fish more.");
            System.out.println("Amount of fish caught: " + caughtFish + " tons.");
        } else {
            System.out.println("You didn't catch enough fish and didn't reach the quota! You need 20 tons of fish more.");
        }
        printMatrix(area);

    }

    private static boolean isInBoundaries(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length &&
                col >= 0 && col < matrix[row].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}