package EncapsulationExercise.PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!toppingType.equals("Meat") && !toppingType.equals("Veggies") && !toppingType.equals("Cheese")
                && !toppingType.equals("Sauce")) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double toppingTypeCalories = getToppingTypeCalories();
        return (2 * weight) * toppingTypeCalories;
    }

    private double getToppingTypeCalories() {
        double calories = 0;
        switch (toppingType) {
            case "Meat":
                calories = 1.2;
                break;
            case "Veggies":
                calories = 0.8;
                break;
            case "Cheese":
                calories = 1.1;
                break;
            case "Sauce":
                calories = 0.9;
                break;
        }
        return calories;
    }
}
