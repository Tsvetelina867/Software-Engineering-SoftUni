package TextProcessingLab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String substring = scanner.nextLine();
        String line = scanner.nextLine();

        while (line.contains(substring)) {
            line = line.replace(substring, "");
        }
        System.out.println(line);
    }
}
