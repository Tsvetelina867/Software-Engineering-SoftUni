package TextProcessingExercise;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String code = scanner.nextLine();

        String result = morseToEnglish(code);
        System.out.println(result);

    }

    public static String morseToEnglish(String morseCode) {
        String[] morseChars = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        char[] englishChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        String[] words = morseCode.replace("|", "").split(" ");

        StringBuilder englishMessage = new StringBuilder();
        for (String word : words) {
            char englishChar = ' ';
            for (int i = 0; i < morseChars.length; i++) {
                if (word.equals(morseChars[i])) {
                    englishChar = englishChars[i];
                    break;
                }
            }
            englishMessage.append(englishChar);
        }

        return englishMessage.toString();
    }
}
