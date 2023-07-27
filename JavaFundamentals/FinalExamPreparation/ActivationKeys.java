package FinalExamPreparation;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] commandTokens = input.split(">>>");
            String command = commandTokens[0];

            switch (command) {
                case "Contains":
                    String substring = commandTokens[1];
                    if (activationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String letterCase = commandTokens[1];
                    int start = Integer.parseInt(commandTokens[2]);
                    int end = Integer.parseInt(commandTokens[3]);
                    String oldString = activationKey.substring(start, end);

                    if (letterCase.equals("Upper")) {
                        activationKey = activationKey.replace(oldString, oldString.toUpperCase());
                        System.out.println(activationKey);
                    } else {
                        activationKey = activationKey.replace(oldString, oldString.toLowerCase());
                        System.out.println(activationKey);
                    }
                    break;
                case "Slice":
                    int startIndex = Integer.parseInt(commandTokens[1]);
                    int endIndex = Integer.parseInt(commandTokens[2]);
                    String subString = activationKey.substring(startIndex, endIndex);
                    activationKey = activationKey.replace(subString, "");
                    System.out.println(activationKey);
                    break;
            }
            input = scanner.nextLine();
         }

        System.out.println("Your activation key is: " + activationKey);
    }
}
