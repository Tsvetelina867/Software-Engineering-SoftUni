package MethodsExercise;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        getMiddleCharacters(input);
    }

    public static void getMiddleCharacters(String text) {
        int length = text.length();
        if (length % 2 == 0) {
            int indexFirstMid = length / 2 - 1;
            int indexSecondMid = length / 2;
            System.out.print(text.charAt(indexFirstMid));
            System.out.print(text.charAt(indexSecondMid));
        } else {
            int indexMid = length / 2;
            System.out.println(text.charAt(indexMid));
        }

    }
}
