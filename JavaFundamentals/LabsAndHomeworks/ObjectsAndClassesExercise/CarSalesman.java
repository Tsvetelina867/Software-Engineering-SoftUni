package ObjectsAndClassesExercise;

import java.util.*;

public class CarSalesman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numEngines = Integer.parseInt(scanner.nextLine());


        Map<String, Engine> enginesMap = new HashMap<>();


        for (int i = 0; i < numEngines; i++) {
            String[] engineInfo = scanner.nextLine().split(" ");
            String model = engineInfo[0];
            int power = 0;
            int displacement = 0;
            String efficiency = "n/a";

            try {
                power = Integer.parseInt(engineInfo[1]);
            } catch (NumberFormatException e) {
                // Handle invalid power input
                power = 0;
            }

            if (engineInfo.length >= 3) {
                // Check if the third element is numeric (representing displacement)
                if (engineInfo[2].matches("-?\\d+")) {
                    displacement = Integer.parseInt(engineInfo[2]);
                } else {
                    efficiency = engineInfo[2];
                }
            }
            if (engineInfo.length >= 4) {
                efficiency = engineInfo[3];
            }

            Engine engine = new Engine(model, power, displacement, efficiency);
            enginesMap.put(model, engine);
        }


        int numCars = Integer.parseInt(scanner.nextLine());


        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < numCars; i++) {
            String[] carInfo = scanner.nextLine().split(" ");
            String model = carInfo[0];
            Engine engine = enginesMap.get(carInfo[1]);
            int weight = 0;
            String color = "n/a";

            if (carInfo.length >= 3) {
                // Check if the third element is numeric (representing weight)
                if (carInfo[2].matches("-?\\d+")) {
                    weight = Integer.parseInt(carInfo[2]);
                } else {
                    color = carInfo[2];
                }
            }
            if (carInfo.length >= 4) {
                color = carInfo[3];
            }

            Car car = new Car(model, engine, weight, color);
            carsList.add(car);
        }

        for (Car car : carsList) {
            System.out.println(car.model + ":");
            System.out.println("  " + car.engine.model + ":");
            System.out.println("    Power: " + car.engine.power);
            System.out.println("    Displacement: " + (car.engine.displacement != 0 ? car.engine.displacement : "n/a"));
            System.out.println("    Efficiency: " + car.engine.efficiency);
            System.out.println("  Weight: " + (car.weight != 0 ? car.weight : "n/a"));
            System.out.println("  Color: " + car.color);
        }
    }

    public static class Car {
        private String model;
        private Engine engine;
        private int weight;
        private String color;

        public Engine getEngine() {
            return engine;
        }

        public String getModel() {
            return model;
        }

        public Car(String model, Engine engine, int weight, String color) {
            this.model = model;
            this.engine = engine;
            this.weight = weight;
            this.color = color;
        }
    }

    public static class Engine {
        private String model;
        private int power;
        private int displacement;
        private String efficiency;

        public Engine (String model, int power, int displacement, String efficiency) {
            this.model = model;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = efficiency;
        }

        public String getModel() {
            return model;
        }

        public int getPower() {
            return power;
        }
    }
}
