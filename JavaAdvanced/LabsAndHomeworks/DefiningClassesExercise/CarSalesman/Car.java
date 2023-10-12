package DefiningClassesExercise.CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this(model, engine, -1, "n/a");
    }
    public Car(String model, Engine engine, String color) {
        this(model, engine, -1, color);
    }
    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getWeight() {
        if (weight == -1) {
            return "n/a";
        }
        return String.valueOf(weight);
    }

    @Override
    public String toString() {
        return String.format("%s:%n%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s",
                this.model, engine.getModel(), engine.getPower(), engine.getDisplacement(), engine.getEfficiency(),
                getWeight(), this.color);
    }
}
