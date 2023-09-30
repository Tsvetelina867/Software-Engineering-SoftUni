package SetsAndMapsLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, LinkedHashMap<String, Double>> storeProducts = new TreeMap<>();

        while (!"Revision".equals(input)) {
            String[] inputTokens = input.split(", ");
            String shop = inputTokens[0];
            String product = inputTokens[1];
            double price = Double.parseDouble(inputTokens[2]);

            storeProducts.putIfAbsent(shop, new LinkedHashMap<>());
            LinkedHashMap<String, Double> products = storeProducts.get(shop);
            products.put(product, price);


            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Double>> store : storeProducts.entrySet()) {
            System.out.println(store.getKey() + "->");

            LinkedHashMap<String, Double> innerData = store.getValue();

            for (Map.Entry<String, Double> entry : innerData.entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
