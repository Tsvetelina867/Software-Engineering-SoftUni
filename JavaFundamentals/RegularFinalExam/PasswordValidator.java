package RegularFinalExam;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        StringBuilder sb = new StringBuilder(password);

        String input = scanner.nextLine();

        while (!input.equals("Complete")) {
            String[] inputTokens = input.split(" ");
            String command = inputTokens[0].toLowerCase();

            switch (command) {
                case "make":
                    if (inputTokens.length != 3) {
                        break;
                    }
                    String caseLetters = inputTokens[1].toLowerCase();
                    int index = Integer.parseInt(inputTokens[2]);
                    if (index < 0 || index >= password.length()) {
                        break;
                    }

                    if (!(password.toCharArray()[index] >= 'A' && password.toCharArray()[index] <= 'z')) {
                        break;
                    }
                    if (caseLetters.equals("upper")) {
                        char letterToReplace = sb.charAt(index);
                        char upperCaseLetter = Character.toUpperCase(letterToReplace);
                        sb.setCharAt(index, upperCaseLetter);
                        password = sb.toString();
                        System.out.println(password);
                    } else if (caseLetters.equals("lower")) {
                        char letterToReplace = sb.charAt(index);
                        char lowerCaseLetter = Character.toLowerCase(letterToReplace);
                        sb.setCharAt(index, lowerCaseLetter);
                        password = sb.toString();
                        System.out.println(password);

                    }
                    break;
                case "insert":
                    if (inputTokens.length != 3) {
                        break;
                    }
                    int indexToInsert = Integer.parseInt(inputTokens[1]);
                    char letterToInsert = inputTokens[2].charAt(0);
                    if (inputTokens[2].length() > 1) {
                        break;
                    }
                    if (indexToInsert >= 0 && indexToInsert < sb.length()) {
                        sb.insert(indexToInsert, letterToInsert);
                        password = sb.toString();
                        System.out.println(password);
                    }
                    break;
                case "replace":
                    if (inputTokens.length != 3) {
                        break;
                    }
                    char charToReplace = inputTokens[1].charAt(0);
                    if (inputTokens[1].length() > 1) {
                        break;
                    }
                    int value = Integer.parseInt(inputTokens[2]);

                    if (password.indexOf(charToReplace) != -1) {
                        int sumResult = (int) charToReplace + value;
                        sumResult %= 128;
                        if (sumResult >= 0 && sumResult <= 127) {
                            for (int i = 0; i < sb.length(); i++) {
                                if (sb.charAt(i) == charToReplace) {
                                    sb.setCharAt(i, (char) sumResult);
                                }
                            }
                            password = sb.toString();
                            System.out.println(password);
                        }
                    }
                    break;
                case "validation":
                    if (inputTokens.length != 1) {
                        break;
                    }
                    if (password.length() < 8) {
                        System.out.println("Password must be at least 8 characters long!");
                    }


                    if (!password.matches("^[A-Za-z\\d_]*$")) {
                        System.out.println("Password must consist only of letters, digits, and _!");
                    }


                    if (!password.matches(".*[A-Z].*")) {
                        System.out.println("Password must consist at least one uppercase letter!");
                    }

                    if (!password.matches(".*[a-z].*")) {
                        System.out.println("Password must consist at least one lowercase letter!");
                    }

                    if (!password.matches(".*\\d.*")) {
                        System.out.println("Password must consist at least one digit!");
                    }

                    break;
                default:
                    break;
            }

            input = scanner.nextLine();
        }
    }
}