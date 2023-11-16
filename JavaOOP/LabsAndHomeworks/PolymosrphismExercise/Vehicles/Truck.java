package PolymosrphismExercise.Vehicles;

public class Truck extends Vehicle{
    private static final double SUMMER_INCREASE_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + SUMMER_INCREASE_CONSUMPTION, tankCapacity);
    }


    @Override
    public void refuel(double fuel) {
        super.refuel(fuel * 0.95);
    }

}

