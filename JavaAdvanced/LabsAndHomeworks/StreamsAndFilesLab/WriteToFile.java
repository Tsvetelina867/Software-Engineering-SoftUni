package StreamsAndFilesLab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        String path = "src/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";

        Set<Character> punctuation = Set.of(',', '.', '!', '?');
        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("write-to-file-output-txt");
        int oneByte = inputStream.read();

        while (oneByte >= 0) {

            char symbol = (char) oneByte;

            if (!punctuation.contains(symbol)) {
                outputStream.write(symbol);
            }

            oneByte = inputStream.read();
        }

        inputStream.close();
        outputStream.close();
    }
}
