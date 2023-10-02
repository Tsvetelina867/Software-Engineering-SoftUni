package SetsAndMapsExercise;

import java.util.*;


public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();
        LinkedHashMap<String, Long> countriesTotalCount = new LinkedHashMap<>();

        while (!"report".equals(input)) {
            String[] tokens = input.split("\\|");
            String city  = tokens[0];
            String country  = tokens[1];
            long population = Long.parseLong(tokens[2]);

           countries.putIfAbsent(country, new LinkedHashMap<>());
           countriesTotalCount.putIfAbsent(country, 0L);
           countries.get(country).put(city, population);

           long populationToAdd = countriesTotalCount.get(country) + population;
           countriesTotalCount.put(country, populationToAdd);

           input = scanner.nextLine();
        }

        countriesTotalCount.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry -> {
                    LinkedHashMap<String, Long> cities = countries.get(entry.getKey());
                    System.out.printf("%s (total population: %d)%n", entry.getKey(), entry.getValue());
                    cities.entrySet().stream()
                            .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                            .forEach(innerMapEntry -> {
                                System.out.printf("=>%s: %d%n", innerMapEntry.getKey(), innerMapEntry.getValue());
                            });
                });
    }
}
