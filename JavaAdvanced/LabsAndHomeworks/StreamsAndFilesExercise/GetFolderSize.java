package StreamsAndFilesExercise;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources";

        File directory = new File(path);
        int size = 0;
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            for (File file : files) {
                if (!file.isDirectory()) {
                    size += (int) file.length();
                }
            }
        }
        System.out.printf("Folder size: %d", size);
    }
}

