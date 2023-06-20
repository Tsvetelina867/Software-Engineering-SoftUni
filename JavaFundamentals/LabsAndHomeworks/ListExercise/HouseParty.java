package ListExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> names = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            String[] commandTokens = command.split(" ");
            String name = commandTokens[0];

            if (command.endsWith("is not going!")) {
                if (names.contains(name)) {
                    names.remove(String.valueOf(name));
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            } else {
                if (!names.contains(name)) {
                    names.add(name);
                } else {
                    System.out.printf("%s is already in the list!%n", name);
                }
            }
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
