package DefiningClassesExercise.RawData;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Car>> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);
            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType,
                    tire1Pressure, tire1Age, tire2Pressure, tire2Age,
                    tire3Pressure, tire3Age, tire4Pressure, tire4Age);
            cars.putIfAbsent(model, new ArrayList<>());
            List<Car> carList = cars.get(model);
            carList.add(car);
        }

        String type = scanner.nextLine();

        if (type.equals("fragile")) {
            cars.values().stream()
                    .filter(carList -> carList.stream().anyMatch(Car::areTiresFragile))
                    .forEach(carList -> carList.forEach(System.out::println));
        } else if (type.equals("flamable")) {
            cars.values().stream()
                    .filter(carList -> carList.stream().anyMatch(Car::isFlamable))
                    .forEach(carList -> carList.forEach(System.out::println));
        }
    }
}
