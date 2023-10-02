package SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();
        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split(" ");
            String ip = tokens[0];
            String user = tokens[2];

            ip = ip.substring(ip.indexOf("=") + 1);
            user = user.substring(user.indexOf("=") + 1);
            users.putIfAbsent(user, new LinkedHashMap<>());
            LinkedHashMap<String, Integer> ipAddresses = users.get(user);
            ipAddresses.putIfAbsent(ip, 0);
            ipAddresses.put(ip, ipAddresses.get(ip) + 1);

            input = scanner.nextLine();
        }

        users.forEach((k, v) -> {
            System.out.println(k + ":");
            int count = 0;
            for (Map.Entry<String, Integer> ipAddress : v.entrySet()) {
                count++;
                System.out.printf("%s => %d", ipAddress.getKey(), ipAddress.getValue());
                if (count < v.size()) {
                    System.out.print(", ");
                } else {
                    System.out.println(".");
                }
            }
        });

    }
}
