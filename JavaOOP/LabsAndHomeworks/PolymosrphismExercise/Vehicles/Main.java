package PolymosrphismExercise.Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carTokens = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carTokens[1]),
                Double.parseDouble(carTokens[2]),
                Double.parseDouble(carTokens[3]));

        String[] truckTokens = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckTokens[1])
                , Double.parseDouble(truckTokens[2]),
                Double.parseDouble(truckTokens[3]));

        String[] busTokens = scanner.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(busTokens[1]),
                Double.parseDouble(busTokens[2]),
                Double.parseDouble(busTokens[3]));
        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String vehicleType = input[1];
            Vehicle currentVehicle = vehicles.get(vehicleType);
            try {
                switch (command) {
                    case "Drive":
                        if (currentVehicle instanceof Bus) {
                            ((Bus) currentVehicle).setEmpty(false);
                            ((Bus) currentVehicle).turnOffAC(false);
                        }
                        double distance = Double.parseDouble(input[2]);
                        currentVehicle.drive(distance);

                        break;
                    case "Refuel":
                        double fuelAmount = Double.parseDouble(input[2]);
                        currentVehicle.refuel(fuelAmount);
                        break;
                    case "DriveEmpty":
                        if (currentVehicle instanceof Bus) {
                            ((Bus) currentVehicle).setEmpty(true);
                            ((Bus) currentVehicle).turnOffAC(true);
                            double distanceEmpty = Double.parseDouble(input[2]);
                            currentVehicle.drive(distanceEmpty);
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        vehicles.values().forEach(System.out::println);
    }
}
