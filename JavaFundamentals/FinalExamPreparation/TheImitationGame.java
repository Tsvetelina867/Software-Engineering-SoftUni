package FinalExamPreparation;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        StringBuilder newString = new StringBuilder(message);

        String input = scanner.nextLine();
        while (!input.equals("Decode")) {
            String[] inputTokens = input.split("\\|");
            String command = inputTokens[0];
            switch (command) {
                case "Move":
                    int n = Integer.parseInt(inputTokens[1]);
                    String moveString = newString.substring(0, n);
                    newString.delete(0, n);
                    newString.append(moveString);
                    break;
                case "Insert":
                    int index = Integer.parseInt(inputTokens[1]);
                    String value = inputTokens[2];
                    newString.insert(index, value);

                    break;
                case "ChangeAll":
                    String substring = inputTokens[1];
                    String replacement = inputTokens[2];
                    String currentMessage = newString.toString();
                    currentMessage = currentMessage.replace(substring, replacement);
                    newString = new StringBuilder(currentMessage);
                    break;
            }
            input = scanner.nextLine();

        }
        System.out.println("The decrypted message is: " + newString);
    }
}