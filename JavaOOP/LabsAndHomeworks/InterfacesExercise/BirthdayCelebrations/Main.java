package InterfacesExercise.BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Birthable> birthdays= new ArrayList<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Citizen":
                Citizen citizen = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                birthdays.add(citizen);
                    break;
                case "Pet":
                    Pet pet = new Pet(tokens[1], tokens[2]);
                    birthdays.add(pet);
                    break;
            }
            input = scanner.nextLine();
        }
        String year = scanner.nextLine();
        birthdays.stream()
                .filter(b -> b.getBirthDate().endsWith(year))
                .forEach(e -> System.out.println(e.getBirthDate()));

    }

}
