package StreamsAndFilesLab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get( "src/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");
        Path outputPath = Paths.get("sort-lines-output.txt");

        List<String> lines = Files.readAllLines(path).stream()
                .sorted()
                .collect(Collectors.toList());

        Files.write(outputPath, lines);


    }
}
