package RegularFinalExam;

import java.util.*;

public class DegustationParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> guestMeals = new LinkedHashMap<>();
        Map<String, Integer> unlikedMeals = new LinkedHashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("Stop")) {
            String[] tokens = input.split("-");
            String command = tokens[0];
            String guest = tokens[1];
            String meal = tokens[2];

            switch (command) {
                case "Like":
                    guestMeals.putIfAbsent(guest, new ArrayList<>());
                    List<String> likedMeals = guestMeals.get(guest);
                    if (!likedMeals.contains(meal)) {
                        likedMeals.add(meal);
                    }
                    break;

                case "Dislike":
                    if (guestMeals.containsKey(guest)) {
                        List<String> dislikedMeals = guestMeals.get(guest);
                        if (dislikedMeals.contains(meal)) {
                            dislikedMeals.remove(meal);
                            System.out.printf("%s doesn't like the %s.%n", guest, meal);
                            unlikedMeals.put(meal, unlikedMeals.getOrDefault(meal, 0) + 1);
                        } else {
                            System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                        }
                    } else {
                        System.out.printf("%s is not at the party.%n", guest);
                    }
                    break;

                default:
                    break;
            }
        }

        for (Map.Entry<String, List<String>> entry : guestMeals.entrySet()) {
            String guest = entry.getKey();
            List<String> meals = entry.getValue();
            System.out.printf("%s: %s%n", guest, String.join(", ", meals));
        }

        System.out.println("Unliked meals: " + unlikedMeals.values().stream().mapToInt(Integer::intValue).sum());
    }
}
