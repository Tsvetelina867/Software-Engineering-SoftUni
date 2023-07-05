package ObjectsAndClassesExercise.VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();

        double carsHorsepower = 0.0;
        double trucksHorsepower = 0.0;
        int carsCount = 0;
        int trucksCount = 0;

        while (!command.equals("End")) {
            String[] commandTokens = command.split(" ");
            String type = commandTokens[0];
            String model = commandTokens[1];
            String color = commandTokens[2];
            double horsepower = Double.parseDouble(commandTokens[3]);

                Vehicle vehicle = new Vehicle(type, model, color, horsepower);
                vehicles.add(vehicle);


            command = scanner.nextLine();
        }

        String model = scanner.nextLine();

        while (!model.equals("Close the Catalogue")) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getModel().equals(model)) {
                    System.out.println(vehicle);
                }
            }

            model = scanner.nextLine();
        }

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equals("car")) {
                carsHorsepower += vehicle.getHorsepower();
                carsCount++;
            } else if (vehicle.getType().equals("truck")) {
                trucksHorsepower += vehicle.getHorsepower();
                trucksCount++;
            }
        }

        double averageCars = carsHorsepower / carsCount;
        if(carsCount == 0) {averageCars = 0;}
        System.out.printf("Cars have average horsepower of: %.2f.%n", averageCars);
        double averageTrucks = trucksHorsepower / trucksCount;
        if(trucksCount == 0) {averageTrucks = 0;}
        System.out.printf("Trucks have average horsepower of: %.2f.%n", averageTrucks);
    }
}
