package BasicSyntax;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = scanner.nextLine();
        String correctPass = "";
        int wrongTry = 1;

        for (int i = username.length() - 1; i >= 0; i--) {
            char currentSymbol = username.charAt(i);
            correctPass += currentSymbol;
        }

        while (!password.equals(correctPass)) {
            wrongTry++;
            System.out.println("Incorrect password. Try again.");
            password = scanner.nextLine();

            if (wrongTry == 4) {
                System.out.printf("User %s blocked!", username);
                break;
            }
        }
        if (password.equals(correctPass)) {
            System.out.printf("User %s logged in.", username);
        }
    }
}
