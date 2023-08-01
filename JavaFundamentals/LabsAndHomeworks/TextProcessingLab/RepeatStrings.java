package TextProcessingLab;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            int currentLength = input[i].length();
            for (int j = 0; j < currentLength; j++) {
                result.append(input[i]);
            }
        }

        System.out.println(result);
    }
}
