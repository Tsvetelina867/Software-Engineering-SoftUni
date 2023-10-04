package StreamsAndFilesLab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ListFiles {
    public static void main(String[] args) {
        String folderPath = "04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";
        String outputPath = "fileList.txt";

        File folder = new File(folderPath);

        try (FileWriter writer = new FileWriter(outputPath)) {
            if (folder.exists() && folder.isDirectory()) {
                File[] files = folder.listFiles();

                if (files != null) {
                    int lineNumber = 1;
                    for (File file : files) {
                        if (file.isFile()) {
                            String fileName = file.getName();
                            long fileSize = file.length();

                            writer.write(lineNumber + "\n");
                            writer.write(fileName + ": [" + fileSize + "]\n");
                            writer.write((fileSize / 1024) + " KB\n\n");
                            lineNumber++;
                        }
                    }
                    System.out.println("File list written to '" + outputPath + "'");
                } else {
                    System.err.println("Failed to list files in the folder.");
                }
            } else {
                System.err.println("The specified path is not a valid folder.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

}
