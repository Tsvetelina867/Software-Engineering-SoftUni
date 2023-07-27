package FinalExamPreparation;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, List<Double>> plantRatingMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> plantRarityMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("<->");
            String plant = input[0];
            int rarity = Integer.parseInt(input[1]);
            plantRatingMap.put(plant, new ArrayList<>());
            plantRarityMap.put(plant, rarity);
        }

        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            String[] inputTokens = input.split(" ");
            String command = inputTokens[0];
            String plant = inputTokens[1];

            switch (command) {
                case "Rate:":
                    double rating = Double.parseDouble(inputTokens[3]);
                    if (plantRatingMap.containsKey(plant)) {
                        plantRatingMap.get(plant).add(rating);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update:":
                    int rarity = Integer.parseInt(inputTokens[3]);
                    if (plantRarityMap.containsKey(plant)) {
                        plantRarityMap.put(plant, rarity);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset:":
                    if (plantRatingMap.containsKey(plant)) {
                        plantRatingMap.get(plant).clear();
                    } else {
                        System.out.println("error");
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        plantRarityMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .thenComparingDouble(x -> plantRatingMap.get(x.getKey()).stream()
                                .mapToDouble(Double::doubleValue)
                                .average().orElse(0.0))
                        .reversed())
                .forEach(entry -> {
                    String plant = entry.getKey();
                    int rarity = entry.getValue();
                    double averageRating = plantRatingMap.get(plant).stream()
                            .mapToDouble(Double::doubleValue)
                            .average().orElse(0.0);
                    System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", plant, rarity, averageRating);
                });

    }
}
