package DefiningClassesExercise.SpeedRacing;

public class Car {


    private String model;
    private double fuelAmount;
    private double fuelCostFor1km;
    private int distanceTravelled;

    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distanceTravelled = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public boolean canDrive(int amountOfKm) {
        double neededFuel = amountOfKm * this.fuelCostFor1km;
        if (fuelAmount >= neededFuel) {
            fuelAmount -= neededFuel;
            distanceTravelled += amountOfKm;
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        return String.format("%s %.2f %d", getModel(), getFuelAmount(), getDistanceTravelled());
    }
}
