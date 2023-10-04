package StreamsAndFilesLab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "src/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        Scanner scanner = new Scanner(new FileInputStream(path));

        PrintWriter printer = new PrintWriter(new FileOutputStream("extract-integers-output.txt"));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                printer.println(scanner.next());
            }
            scanner.next();
        }

        printer.close();

    }
}
