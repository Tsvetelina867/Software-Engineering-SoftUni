package DefiningClassesExercise.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            Engine engine = null;

            if (tokens.length == 2) {
                engine = new Engine(model, power);
            } else if (tokens.length == 3) {
                if (tokens[2].matches("\\d+")) {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                } else {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
            } else if (tokens.length == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
            }
            engines.add(engine);
        }

        List<Car> cars = new ArrayList<>();
        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            String modelOfEngine = tokens[1];
            Car car = null;
            Engine engineToPut = getEngine(engines, modelOfEngine);

            if (tokens.length == 2) {
                car = new Car(model, engineToPut);
            } else if (tokens.length == 3) {
                if (tokens[2].matches("\\d+")) {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engineToPut, weight);
                } else {
                    String color = tokens[2];
                    car = new Car(model, engineToPut, color);
                }
            } else if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model, engineToPut, weight, color);
            }

            cars.add(car);
        }
        cars.forEach(System.out::println);
    }

    private static Engine getEngine(List<Engine> engines, String modelOfEngine) {
        Engine engineToPut = null;
        for (Engine engine : engines) {
            if (engine.getModel().equals(modelOfEngine)) {
                engineToPut = engine;
            }
        }
        return engineToPut;
    }

}
