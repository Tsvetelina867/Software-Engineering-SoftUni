package EncapsulationExercise.PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("EncapsulationExercise.PizzaCalories.Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }
    public double calculateCalories() {
        double caloriesOfFlourType = getFlourTypeCalories();
        double caloriesOfBakingType = getBakingCalories();

        return (2 * weight) * caloriesOfFlourType * caloriesOfBakingType;
    }

    private double getBakingCalories() {
        double bakingCalories = 0;
        switch (bakingTechnique) {
            case "Crispy":
                bakingCalories = 0.9;
                break;
            case "Chewy":
                bakingCalories = 1.1;
                break;
            case "Homemade":
                bakingCalories = 1.0;
                break;
        }
        return bakingCalories;
    }

    private double getFlourTypeCalories() {
        double flourTypeCalories = 0;
        switch (flourType) {
            case "White":
                flourTypeCalories = 1.5;
                break;
            case "Wholegrain":
                flourTypeCalories = 1.0;
                break;
        }
        return flourTypeCalories;
    }
}
