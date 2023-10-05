package StreamsAndFilesExercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers {
    public static void main(String[] args) {
        String inputPath = "src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";
        String outputPath = "src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath))) {
            String line = reader.readLine();
            int count = 0;
            while (line != null) {
                count++;
                writer.write(count + ". " + line);
                writer.newLine();
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
