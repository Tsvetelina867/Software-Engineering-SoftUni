package MapsLambdaAndStreamAPILab;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().toLowerCase().split(" ");

        LinkedHashMap<String, Integer> countMap = new LinkedHashMap<>();
        for (int i = 0; i < input.length; i++) {
            countMap.putIfAbsent(input[i], 0);
            countMap.put(input[i], countMap.get(input[i]) + 1);
        }

        List<String> odds = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                odds.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", odds));

    }
}
