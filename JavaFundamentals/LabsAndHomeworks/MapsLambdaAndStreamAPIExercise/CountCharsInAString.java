package MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<Character, Integer> countMap = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (currentSymbol != ' ') {
                countMap.putIfAbsent(currentSymbol, 0);
                countMap.put(currentSymbol, countMap.get(currentSymbol) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            char letter = entry.getKey();
            int occurrences = entry.getValue();
            System.out.printf("%c -> %d%n", letter, occurrences);
        }
    }
}
