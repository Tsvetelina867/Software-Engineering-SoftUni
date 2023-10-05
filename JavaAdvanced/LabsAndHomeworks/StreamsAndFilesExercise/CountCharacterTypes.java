package StreamsAndFilesExercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = "src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String outputPath = "src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt";

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = Set.of('!', ',', '?', '.');
        long countVowels = 0;
        long countPunctuation = 0;
        long countOtherSymbols = 0;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath))) {
            String line = reader.readLine();
            while (line != null) {
                for (char c : line.toCharArray()) {
                    if (vowels.contains(c)) {
                        countVowels++;
                    } else if (punctuation.contains(c)) {
                        countPunctuation++;
                    } else if (c == ' ') {
                        continue;
                    } else {
                        countOtherSymbols++;
                    }
                }
                line = reader.readLine();
            }
            writer.write("Vowels: " + countVowels);
            writer.newLine();
            writer.write("Other symbols: " + countOtherSymbols);
            writer.newLine();
            writer.write("Punctuation: " + countPunctuation);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
