package PolymosrphismExercise.Vehicles;

public class Bus extends Vehicle {

    private static final boolean DEFAULT_BUS_IS_EMPTY = true;
    private boolean isEmpty;
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.isEmpty = DEFAULT_BUS_IS_EMPTY;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public void turnOffAC(boolean isEmpty) {
        if (isEmpty) {
            super.setFuelConsumption(getFuelConsumption());
        } else {
            super.setFuelConsumption(getFuelConsumption() + 1.4);
        }
    }
}
