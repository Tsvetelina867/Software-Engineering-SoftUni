package Abstraction;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= n; i++) {
            printRhombusLine(n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            printRhombusLine(n, i);
        }
    }

    private static void printRhombusLine(int n, int i) {
        for (int space = 0; space < n - i; space++) {
            System.out.print(" ");
        }

        for (int j = 0; j < i; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}