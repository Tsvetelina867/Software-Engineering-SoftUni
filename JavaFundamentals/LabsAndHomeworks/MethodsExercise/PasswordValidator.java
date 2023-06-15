package MethodsExercise;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pass = scanner.nextLine();
        validatingPassword(pass);
    }

    public static boolean validatingLength (String pass) {
        if (pass.length() < 6 || pass.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }
        return true;

    }

    public static boolean validatingConsistency (String pass) {
        for (int i = 0; i < pass.length(); i++) {
            char symbol = pass.charAt(i);
            if (!Character.isLetterOrDigit(symbol)) {
                System.out.println("Password must consist only of letters and digits");
                return false;
            }
        }
        return true;
    }

    public static boolean validatingDigitCount (String pass) {
        int count = 0;
        for (int i = 0; i < pass.length(); i++) {
            char symbol = pass.charAt(i);
            if (Character.isDigit(symbol)) {
                count++;
            }
        }
        if (count < 2) {
            System.out.println("Password must have at least 2 digits");
            return false;
        }
        return true;
    }

    public static void validatingPassword (String pass) {
        boolean isValid = true;

        if (!validatingLength(pass)) {
            isValid = false;
        }
        if (!validatingConsistency(pass)) {
            isValid = false;
        }
        if (!validatingDigitCount(pass)) {
            isValid = false;
        }
        if (isValid) {
            System.out.println("Password is valid");
        }
    }
}
