package ObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RawData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            ArrayList<Tire> tires = new ArrayList<>();

            Tire tire = new Tire(Double.parseDouble(input[5]), Integer.parseInt(input[6]),
                    Double.parseDouble(input[7]), Integer.parseInt(input[8]),
                    Double.parseDouble(input[9]), Integer.parseInt(input[10]),
                    Double.parseDouble(input[11]), Integer.parseInt(input[12]));
            tires.add(tire);

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command = scanner.nextLine();
        List<String> model = new ArrayList<>();

        for (Car car : cars) {
            if (car.getCargo().getType().equals("fragile") && command.equals("fragile")) {
                for (Tire tire : car.getTires()) {
                    if (tire.getPressure1() < 1 || tire.getPressure2() < 1 || tire.getPressure3() < 1 || tire.getPressure4() < 1) {
                        model.add(car.getModel());
                        break;
                    }
                }
            } else if (car.getCargo().getType().equals("flamable") && command.equals("flamable")) {
                if (car.getEngine().getPower() > 250) {
                    model.add(car.getModel());
                }
            }
        }

        model.forEach(System.out::println);

    }


    public static class Car {
        private String model;
        private Engine engine;
        private Cargo cargo;
        private ArrayList<Tire> tires;

        public Cargo getCargo() {
            return cargo;
        }

        public Engine getEngine() {
            return engine;
        }

        public List<Tire> getTires() {
            return tires;
        }

        public String getModel() {
            return model;
        }

        public Car (String model, Engine engine, Cargo cargo, ArrayList<Tire> tires) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tires = tires;
        }

    }

    public static class Engine {
        private int speed;
        private int power;

        public int getPower() {
            return power;
        }

        public int getSpeed() {
            return speed;
        }

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }
    }

    public static class Tire {
        private double pressure1;
        private int age1;
        private double pressure2;
        private int age2;
        private double pressure3;
        private int age3;
        private double pressure4;
        private int age4;

        public double getPressure1() {
            return pressure1;
        }

        public double getPressure2() {
            return pressure2;
        }

        public double getPressure3() {
            return pressure3;
        }

        public double getPressure4() {
            return pressure4;
        }

        public Tire(double pressure1, int age1, double pressure2, int age2, double pressure3, int age3, double pressure4, int age4) {
            this.pressure1 = pressure1;
            this.age1 = age1;
            this.pressure2 = pressure2;
            this.age2 = age2;
            this.pressure3 = pressure3;
            this.age3 = age3;
            this.pressure4 = pressure4;
            this.age4 = age4;
        }
    }

    public static class Cargo {
        private int weight;
        private String type;

        public int getWeight() {
            return weight;
        }

        public String getType() {
            return type;
        }
        public Cargo (int weight, String type) {
            this.weight = weight;
            this.type = type;
        }
    }
}
