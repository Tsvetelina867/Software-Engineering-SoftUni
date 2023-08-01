package TextProcessingExercise;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();

        int indexOfDot = path.indexOf(".");
        int indexOfLine = path.lastIndexOf("\\");

        String fileName = path.substring(indexOfLine + 1, indexOfDot);
        String fileExtension = path.substring(indexOfDot + 1);

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + fileExtension);
    }
}
