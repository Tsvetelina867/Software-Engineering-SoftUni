package InterfacesLab.Car;

public class Audi extends CarImpl implements Rentable {
    private Integer miniRentDay;
    private Double pricePerDay;
    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer miniRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.miniRentDay = miniRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return miniRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + "Minimum rental period of " + miniRentDay + " days. Price per day " + pricePerDay;
    }
}
