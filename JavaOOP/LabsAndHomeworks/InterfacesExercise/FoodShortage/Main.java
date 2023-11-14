import InterfacesExercise.FoodShortage.Buyer;
import InterfacesExercise.FoodShortage.Citizen;
import InterfacesExercise.FoodShortage.Rebel;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyers = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input.length == 3) {
                Rebel rebel = new Rebel(input[0], Integer.parseInt(input[1]), input[2]);
                buyers.put(input[0], rebel);
            } else if (input.length == 4) {
                Citizen citizen = new Citizen(input[0], Integer.parseInt(input[1]), input[2], input[3]);
                buyers.put(input[0], citizen);
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            if (buyers.containsKey(input)) {
                buyers.get(input).buyFood();
            }
            input = scanner.nextLine();
        }

        int totalFood = buyers.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(totalFood);
    }

}
