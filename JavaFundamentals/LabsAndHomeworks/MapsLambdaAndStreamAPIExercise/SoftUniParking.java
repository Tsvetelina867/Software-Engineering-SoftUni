package MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> usersMap = new LinkedHashMap<>();
        
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] inputTokens = input.split(" ");
            String command = inputTokens[0];

            if (command.equals("register")) {
                String username = inputTokens[1];
                String licensePlateNumber = inputTokens[2];
                if (!usersMap.containsKey(username)) {
                    usersMap.put(username, licensePlateNumber);
                    System.out.printf("%s registered %s successfully%n", username, licensePlateNumber);
                } else {
                    System.out.println("ERROR: already registered with plate number " + usersMap.get(username));
                }

            } else {
                String username = inputTokens[1];
                if (usersMap.containsKey(username)) {
                    usersMap.remove(username);
                    System.out.println(username + " unregistered successfully");
                } else {
                    System.out.printf("ERROR: user %s not found%n", username);
                }
            }
        }

        for (Map.Entry<String, String> entry : usersMap.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }
    }
}
