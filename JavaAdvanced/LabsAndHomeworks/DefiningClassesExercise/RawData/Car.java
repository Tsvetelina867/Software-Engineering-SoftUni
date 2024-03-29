package DefiningClassesExercise.RawData;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType,
               double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age,
               double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tires = new ArrayList<>();
        tires.add(new Tire(tire1Pressure, tire1Age));
        tires.add(new Tire(tire2Pressure, tire2Age));
        tires.add(new Tire(tire3Pressure, tire3Age));
        tires.add(new Tire(tire4Pressure, tire4Age));
    }


    public boolean areTiresFragile() {
        for (Tire tire : tires) {
            if (tire.getPressure() < 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isFlamable() {
        return engine.getPower() > 250;
    }

    @Override
    public String toString() {
        return model;
    }
}
