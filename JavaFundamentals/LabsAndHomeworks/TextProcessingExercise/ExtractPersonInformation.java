package TextProcessingExercise;

import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            int startName = input.indexOf("@");
            int endName = input.indexOf("|");
            String name = input.substring(startName + 1, endName);
            int startAge = input.indexOf("#");
            int endAge = input.indexOf("*");
            String age = input.substring(startAge + 1, endAge);
            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
