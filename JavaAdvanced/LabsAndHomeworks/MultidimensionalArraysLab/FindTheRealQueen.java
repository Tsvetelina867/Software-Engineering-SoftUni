package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];
        for (int i = 0; i < matrix.length; i++) {
            char[] arr = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[i] = arr;
        }
        boolean isRealQueen = false;
        int queenRow = -1;
        int queenCol = -1;

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[0].length; cols++) {
                if (matrix[rows][cols] == 'q') {
                    if (isRealQueen(rows, cols, matrix)) {
                        isRealQueen = true;
                        queenRow = rows;
                        queenCol = cols;
                        break;
                    }
                }
            }
            if (isRealQueen) {
                break;
            }

        }
        if (isRealQueen) {
            System.out.println(queenRow + " " + queenCol);
        } else {
            System.out.println("No valid queen position");
        }
    }

        private static boolean isRealQueen ( int row, int col, char[][] matrix){
            return checkUpAndDown(matrix, row, col) &&
                    checkRightAndLeft(matrix, row, col) &&
                    checkDiagonals(matrix, row, col);
        }

        private static boolean checkDiagonals ( char[][] matrix, int row, int col){
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (matrix[i][j] == 'q') {
                    return false;
                }
            }

            for (int i = row - 1, j = col + 1; i >= 0 && j < matrix[0].length; i--, j++) {
                if (matrix[i][j] == 'q') {
                    return false;
                }
            }

            for (int i = row + 1, j = col - 1; i < matrix.length && j >= 0; i++, j--) {
                if (matrix[i][j] == 'q') {
                    return false;
                }
            }

            for (int i = row + 1, j = col + 1; i < matrix.length && j < matrix[0].length; i++, j++) {
                if (matrix[i][j] == 'q') {
                    return false;
                }
            }
            return true;
        }

        private static boolean checkRightAndLeft ( char[][] matrix, int rows, int cols){
            for (int i = cols - 1; i >= 0; i--) { //left
                if (matrix[rows][i] == 'q') {
                    return false;
                }
            }
            for (int i = cols + 1; i < matrix[0].length; i++) { //right
                if (matrix[rows][i] == 'q') {
                    return false;
                }
            }
            return true;
        }

        private static boolean checkUpAndDown ( char[][] matrix, int rows, int cols){
            for (int i = rows - 1; i >= 0; i--) { // up
                if (matrix[i][cols] == 'q') {
                    return false;
                }
            }
            for (int i = rows + 1; i < matrix.length; i++) { //down
                if (matrix[i][cols] == 'q') {
                    return false;
                }
            }
            return true;
        }


    }
