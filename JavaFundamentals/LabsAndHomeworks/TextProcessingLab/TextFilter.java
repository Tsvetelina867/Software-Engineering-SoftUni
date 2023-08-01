package TextProcessingLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> bannedWords = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();


        for (String bannedWord : bannedWords) {
            String replacement = replaceWord(bannedWord);
            input = input.replaceAll(bannedWord, replacement);
        }
        System.out.println(input);

    }

    public static String replaceWord(String word) {
        StringBuilder asterisk = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            asterisk.append("*");
        }
        return asterisk.toString();
    }
}
