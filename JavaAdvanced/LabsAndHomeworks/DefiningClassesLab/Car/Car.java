package DefiningClassesLab.Car;
public class Car {

    public String model;
    public String brand;
    public int horsePower;

    public Car() {

    }
    public Car(String brand) {
        this(brand, "unknown", -1);
    }
    public Car (String brand, String model) {
        this(brand, model, -1);
    }
    public Car(String brand, int horsePower) {
        this(brand, "unknown", horsePower);
    }
    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String carInfo() {
        return toString();
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", getBrand(), getModel(), getHorsePower());
    }
}
