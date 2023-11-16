package PolymosrphismExercise.Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }


    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void drive(double km) {
        double neededFuel = this.fuelConsumption * km;
        if (fuelQuantity >= neededFuel) {
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), DECIMAL_FORMAT.format(km));
            fuelQuantity -= neededFuel;
        } else {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
    }
    public void refuel(double fuel) {
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (this.fuelQuantity + fuel > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        fuelQuantity += fuel;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), fuelQuantity);
    }
}
