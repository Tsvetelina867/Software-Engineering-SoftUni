package MethodsExercise;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstSymbol = scanner.nextLine().charAt(0);
        char secondSymbol = scanner.nextLine().charAt(0);

        printASCIIBetweenChars(firstSymbol, secondSymbol);
    }

    public static void printASCIIBetweenChars (char start, char end) {
        if (start <= end) {
            for (char i = (char) (start + 1); i < end; i++) {
                System.out.print(i + " ");
            }
        } else if (start > end) {
            for (char i = (char) (end + 1); i < start; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
