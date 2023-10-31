package EncapsulationExercise.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String[] pizzaInfo = scanner.nextLine().split("\\s+");
            String pizzaName = pizzaInfo[1];
            int numberOfToppings = Integer.parseInt(pizzaInfo[2]);

            Pizza pizza = new Pizza(pizzaName, numberOfToppings);

            String[] doughInfo = scanner.nextLine().split("\\s+");
            String flourType = doughInfo[1];
            String bakingTechnique = doughInfo[2];
            double doughWeight = Double.parseDouble(doughInfo[3]);

            Dough dough = new Dough(flourType, bakingTechnique, doughWeight);
            pizza.setDough(dough);

            for (int i = 0; i < numberOfToppings; i++) {
                String[] toppingInfo = scanner.nextLine().split("\\s+");
                String toppingType = toppingInfo[1];
                double toppingWeight = Double.parseDouble(toppingInfo[2]);

                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);
            }
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
