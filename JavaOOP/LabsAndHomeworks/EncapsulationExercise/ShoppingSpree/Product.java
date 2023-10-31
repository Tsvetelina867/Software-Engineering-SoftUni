package EncapsulationExercise.ShoppingSpree;

public class Product {
   private String name;
   private double cost;

    public Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        Validator.validateString(name);
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    private void setCost(double cost) {
        Validator.validateNonNegativeNumber(cost);
        this.cost = cost;
    }
}
