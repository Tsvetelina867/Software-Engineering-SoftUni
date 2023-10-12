package DefiningClassesExercise.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostPer1Km = Double.parseDouble(tokens[2]);
            Car car = new Car(model, fuelAmount, fuelCostPer1Km);

            cars.put(model, car);
        }

        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String model = tokens[1];
            int amountKm = Integer.parseInt(tokens[2]);
            if (!cars.get(model).canDrive(amountKm)) {
                System.out.println("Insufficient fuel for the drive");
            }

            line = scanner.nextLine();
        }

        cars.forEach((key, value) -> System.out.println(value));
    }
}
