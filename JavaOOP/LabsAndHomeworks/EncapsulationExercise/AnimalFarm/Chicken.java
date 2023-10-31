package EncapsulationExercise.AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }
    private double calculateProductPerDay() {
        if (age < 6) {
            return 2;
        } else if (age > 6 && age < 13) {
            return 1;
        }
        return 0.75;
    }

    public double productPerDay () {
        return calculateProductPerDay();
    }

    public String toString() {
        return String.format("EncapsulationExercise.AnimalFarm.Chicken Chichi (age %d) can produce %.2f eggs per day.", age, productPerDay());
    }
}
