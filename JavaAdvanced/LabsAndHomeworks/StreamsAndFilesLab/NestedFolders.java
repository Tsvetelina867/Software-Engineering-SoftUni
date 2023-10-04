package StreamsAndFilesLab;

import java.io.File;

public class NestedFolders {
    public static void main(String[] args) {


        String folderPath = "04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";

        File folder = new File(folderPath);


        if (folder.exists() && folder.isDirectory()) {

            int directoryCount = listDirectories(folder);


            System.out.println("[" + directoryCount + " folders]");
        } else {
            System.err.println("The specified path is not a valid folder.");
        }
    }

    private static int listDirectories(File folder) {
        int directoryCount = 1;

        File[] filesAndDirs = folder.listFiles();

        if (filesAndDirs != null) {
            for (File fileOrDir : filesAndDirs) {
                if (fileOrDir.isDirectory()) {
                    String directoryName = fileOrDir.getName();

                    System.out.println(directoryName);
                    directoryCount += listDirectories(fileOrDir);
                }
            }
        } else {
            System.err.println("Failed to list files and directories in the folder.");
        }

        return directoryCount;
    }

}

