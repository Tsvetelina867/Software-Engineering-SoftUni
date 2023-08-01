package TextProcessingExercise;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstSymbol = scanner.nextLine().charAt(0);
        char secondSymbol = scanner.nextLine().charAt(0);
        String randomInput = scanner.nextLine();
        char startChar = (char) Math.min(firstSymbol, secondSymbol);
        char endChar = (char) Math.max(firstSymbol, secondSymbol);

        int sum = 0;
        for (int i = 0; i < randomInput.length(); i++) {
            char ch = randomInput.charAt(i);
            if (ch > startChar && ch < endChar) {
                sum += ch;
            }
        }

        System.out.println(sum);
    }
}
