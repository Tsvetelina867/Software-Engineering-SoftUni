import java.util.Random;
import java.util.Scanner;

public class GuessANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random randomNumber = new Random();
        int computerNumber = randomNumber.nextInt(100) + 1;
        while (true) {
            System.out.print("Guess a number (1-100): ");
            String playerInput = scanner.nextLine();

            if (playerInput.equalsIgnoreCase("exit") || playerInput.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                break;
            }
            if (playerInput.isEmpty()) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            boolean isValid = true;
            for (int i = 0; i < playerInput.length(); i++) {
                if (!Character.isDigit(playerInput.charAt(i))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                int playerNumber = Integer.parseInt(playerInput);

                if (playerNumber == computerNumber) {
                    System.out.println("You guessed it!");
                    return;
                } else if (playerNumber > computerNumber) {
                    System.out.println("Too High!");
                } else {
                    System.out.println("Too Low!");
                }
            } else {
                System.out.println("Invalid input. Please enter a number!");
            }
        }
    }
}
