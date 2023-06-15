package MethodsExercise;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            isPalindrome(input);
            input = scanner.nextLine();
        }
    }

    public static void isPalindrome(String text) {
        String reversedText = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversedText += text.charAt(i);
        }
        if (reversedText.equals(text)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
