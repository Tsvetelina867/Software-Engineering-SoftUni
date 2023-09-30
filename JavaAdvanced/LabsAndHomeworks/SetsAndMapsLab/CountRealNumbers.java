package SetsAndMapsLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        LinkedHashMap<Double, Integer> occurrences = new LinkedHashMap<>();

        for (double number : numbers) {
            if (!occurrences.containsKey(number)) {
                occurrences.putIfAbsent(number, 1);
            } else {
                occurrences.put(number, occurrences.get(number) + 1);
            }
        }

        for (Map.Entry<Double, Integer> occurrence : occurrences.entrySet()) {
            System.out.printf("%.1f -> %d%n", occurrence.getKey(), occurrence.getValue());
        }
    }
}
