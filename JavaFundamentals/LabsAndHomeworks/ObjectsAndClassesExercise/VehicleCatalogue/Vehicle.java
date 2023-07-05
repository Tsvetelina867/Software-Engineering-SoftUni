package ObjectsAndClassesExercise.VehicleCatalogue;

public class Vehicle {
    private String type;
    private String model;
    private String color;
    private double horsepower;

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getHorsepower() {
        return horsepower;
    }

    public Vehicle (String type, String model, String color, double horsepower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }
    public String toString() {
        String typeVeh = type.equals("car") ? "Car" : "Truck";
        return "Type: " + typeVeh + "\n" +
                "Model: " +  model + "\n" +
                "Color: " + color + "\n" +
                "Horsepower: " + Math.round(horsepower);
    }

}
