package TextProcessingExercise;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        for (char c : text.toCharArray()) {
            int newCode = c + 3;
            char newSymbol = (char)newCode;
            sb.append(newSymbol);
        }

        System.out.println(sb);
    }
}
