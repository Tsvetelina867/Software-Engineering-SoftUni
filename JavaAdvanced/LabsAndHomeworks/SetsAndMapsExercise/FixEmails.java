package SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        LinkedHashMap<String, String> users = new LinkedHashMap<>();
        while (!"stop".equals(name)) {
            String email = scanner.nextLine();
            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")) {
                users.put(name, email);
            }
            name = scanner.nextLine();
        }

        users.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });
    }
}
