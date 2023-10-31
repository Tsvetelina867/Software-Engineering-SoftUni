package EncapsulationExercise.ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] people = scanner.nextLine().split(";");
        String[] products = scanner.nextLine().split(";");
        List<Product> productsList = new ArrayList<>();
        List<Person> personList = new ArrayList<>();

        for (String string : products) {
            int indexOfDelimiter = string.indexOf("=");
            String name = string.substring(0, indexOfDelimiter);
            double cost = Double.parseDouble(string.substring(indexOfDelimiter + 1));
            try {
                Product product = new Product(name, cost);
                productsList.add(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        for (String person : people) {
            int indexOfDelimiter = person.indexOf("=");
            String name = person.substring(0, indexOfDelimiter);
            double money = Double.parseDouble(person.substring(indexOfDelimiter + 1));
            try {
                Person person1 = new Person(name, money);
                personList.add(person1);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        Map<Person, ArrayList<Product>> peopleMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];

            Person buyer = personList.stream()
                    .filter(person -> person.getName().equals(personName))
                    .findFirst()
                    .orElse(null);

            Product orderedProduct = productsList.stream()
                    .filter(product -> product.getName().equals(productName))
                    .findFirst()
                    .orElse(null);

            if (buyer != null && orderedProduct != null) {
                try {
                    peopleMap.putIfAbsent(buyer, new ArrayList<>());
                    buyer.buyProduct(orderedProduct);
                    peopleMap.get(buyer).add(orderedProduct);
                    System.out.println(personName + " bought " + productName);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<Person, ArrayList<Product>> entry : peopleMap.entrySet()) {
            Person person = entry.getKey();
            if (entry.getValue().isEmpty()) {
                System.out.println(person.getName() + " – Nothing bought");
            } else {
                String productNames = entry.getValue()
                        .stream()
                        .map(Product::getName)
                        .collect(Collectors.joining(", "));
                System.out.println(person.getName() + " - " + productNames);
            }
        }
    }
}
