package StreamsAndFilesExercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllCapitals {
    public static void main(String[] args) {
        String inputPath = "src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String outputPath = "src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath))){
            String line = reader.readLine();
            while (line != null) {
                writer.write(line.toUpperCase());
                writer.newLine();
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
