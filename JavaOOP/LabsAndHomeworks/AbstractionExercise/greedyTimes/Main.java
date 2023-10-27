package AbstractionExercise.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long input = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();
        long gold = 0;
        long gems = 0;
        long cash = 0;

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long amount = Long.parseLong(safe[i + 1]);

            String typeOfItem = "";

            typeOfItem = determineItemType(name, typeOfItem);

            if (typeOfItem.isEmpty() || isBagCapacityExceeded(input, bag, amount) || isValidItem(typeOfItem, bag, amount)) {
                continue;
            }


            updateBag(bag, typeOfItem, name, amount);

            if (typeOfItem.equals("Gold")) {
                gold += amount;
            } else if (typeOfItem.equals("Gem")) {
                gems += amount;
            } else if (typeOfItem.equals("Cash")) {
                cash += amount;
            }
        }


        printBagContents(bag);
    }

    private static void printBagContents(Map<String, LinkedHashMap<String, Long>> bag) {
        for (Map.Entry<String, LinkedHashMap<String, Long>> x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static void updateBag(Map<String, LinkedHashMap<String, Long>> bag, String typeOfItem, String name, long amount) {
        bag.putIfAbsent(typeOfItem, new LinkedHashMap<String, Long>());
        bag.get(typeOfItem).putIfAbsent(name, 0L);

        bag.get(typeOfItem).put(name, bag.get(typeOfItem).get(name) + amount);
    }

    private static boolean isValidItem(String typeOfItem, Map<String, LinkedHashMap<String, Long>> bag, long amount) {
        switch (typeOfItem) {
            case "Gem":
                if (!bag.containsKey(typeOfItem)) {
                    if (bag.containsKey("Gold")) {
                        long sumOfGold = bag.get("Gold").values().stream().mapToLong(e -> e).sum();
                        if (amount > sumOfGold) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                    break;
                }
            case "Cash":
                if (!bag.containsKey(typeOfItem)) {
                    if (bag.containsKey("Gem")) {
                        if (amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                } else if (bag.get(typeOfItem).values().stream().mapToLong(e -> e).sum() + amount > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                    return true;
                }
                break;
        }
        return false;
    }

    private static boolean isBagCapacityExceeded(long input, Map<String, LinkedHashMap<String, Long>> bag, long amount) {
        return input < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + amount;
    }

    private static String determineItemType(String name, String typeOfItem) {
        if (name.length() == 3) {
            typeOfItem = "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            typeOfItem = "Gem";
        } else if (name.toLowerCase().equals("gold")) {
            typeOfItem = "Gold";
        }
        return typeOfItem;
    }
}