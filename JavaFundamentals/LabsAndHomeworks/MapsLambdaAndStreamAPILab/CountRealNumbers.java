package MapsLambdaAndStreamAPILab;

import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        TreeMap<Double, Integer> countNumbers = new TreeMap<>();
        for (Double num : list) {
            if (!countNumbers.containsKey(num)) {
                countNumbers.put(num, 1);
            } else {
                countNumbers.put(num, countNumbers.get(num) + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : countNumbers.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
