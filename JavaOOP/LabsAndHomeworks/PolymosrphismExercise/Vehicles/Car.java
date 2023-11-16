package PolymosrphismExercise.Vehicles;

public class Car extends Vehicle{
    private static final double SUMMER_INCREASE_CONSUMPTION = 0.9;


    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + SUMMER_INCREASE_CONSUMPTION, tankCapacity);
    }
}
