package StreamsAndFilesExercise;

import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        try {
            List<String> phrasesToCount = readPhrases("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt");
            String text = readText("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt");

            Map<String, Integer> phraseFrequencyMap = new HashMap<>();

            for (String phrase : phrasesToCount) {
                int count = 0;
                int index = text.indexOf(phrase.toLowerCase());

                while (index != -1) {
                    count++;
                    index = text.indexOf(phrase.toLowerCase(), index + 1);
                }

                phraseFrequencyMap.put(phrase, count);
            }

            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(phraseFrequencyMap.entrySet());
            sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

            writeResults("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/results.txt", sortedEntries);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readPhrases(String fileName) throws IOException {
        List<String> phrases = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            phrases.addAll(Arrays.asList(parts));
        }
        reader.close();
        return phrases;
    }

    private static String readText(String fileName) throws IOException {
        StringBuilder text = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            text.append(line).append(" ");
        }
        reader.close();
        return text.toString().toLowerCase();
    }

    private static void writeResults(String fileName, List<Map.Entry<String, Integer>> sortedEntries) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            writer.write(entry.getKey() + " - " + entry.getValue() + "\n");
        }
        writer.close();
    }

}
