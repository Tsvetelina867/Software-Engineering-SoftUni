package TextProcessingExercise;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        for (int i = 0; i < input.length; i++) {
            String currentUsername = input[i];
            if (isValid(currentUsername)) {
                System.out.println(currentUsername);
            }
        }
    }

    public static boolean isValid (String username) {
        int length = username.length();
        if (length < 3 || length > 16) {
            return false;
        }

        for (char c : username.toCharArray()) {
            if (!(Character.isLetter(c) || Character.isDigit(c) || c == '-' || c == '_')) {
                return false;
            }
        }

        return true;
    }
}
