package SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, TreeMap<String, Integer>> users = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            users.putIfAbsent(user, new TreeMap<>());
            TreeMap<String, Integer> ips = users.get(user);
            ips.put(ip, ips.getOrDefault(ip, 0) + duration);

        }

        users.forEach((user, ips) -> {
            int totalDuration = ips.values().stream().mapToInt(Integer::intValue).sum();
            String ipList = String.join(", ", ips.keySet());
            System.out.printf("%s: %d [%s]%n", user, totalDuration, ipList);
        });
    }
}
