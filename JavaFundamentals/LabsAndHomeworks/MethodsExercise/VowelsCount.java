package MethodsExercise;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();
        countVowels(input);
    }

    public static void countVowels (String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (symbol == 'a' || symbol == 'o' || symbol == 'e' || symbol == 'u' || symbol == 'i') {
                count++;
            }
        }
        System.out.println(count);
    }
}
