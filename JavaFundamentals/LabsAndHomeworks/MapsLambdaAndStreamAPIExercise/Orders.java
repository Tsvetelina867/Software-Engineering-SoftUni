package MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, Double> productsMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> productsQuantityMap = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String[] inputArgs = input.split(" ");
            String name = inputArgs[0];
            double price = Double.parseDouble(inputArgs[1]);
            int quantity = Integer.parseInt(inputArgs[2]);

            if (!productsMap.containsKey(name)) {
                productsMap.put(name, price * quantity);
                productsQuantityMap.put(name, quantity);
            } else {
                int totalQuantity = productsQuantityMap.get(name) + quantity;
                productsMap.put(name, price * totalQuantity);
                productsQuantityMap.put(name, totalQuantity);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Double> entry : productsMap.entrySet()) {
            String name = entry.getKey();
            double totalPrice = entry.getValue();
            System.out.printf("%s -> %.2f%n", name, totalPrice);
        }
    }
}
