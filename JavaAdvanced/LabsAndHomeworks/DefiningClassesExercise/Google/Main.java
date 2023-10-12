package DefiningClassesExercise.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new HashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {
            String[] tokens = input.split(" ");
            String name = tokens[0];

            people.putIfAbsent(name, new Person(name));

            String category = tokens[1];

            switch (category) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    people.get(name).setCompany(companyName, department, salary);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    people.get(name).addPokemon(pokemonName, pokemonType);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    people.get(name).addParent(parentName, parentBirthday);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    people.get(name).addChild(childName, childBirthday);
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);
                    people.get(name).setCar(carModel, carSpeed);
                    break;
            }
        }

        String personNameToPrint = scanner.nextLine();
        if (people.containsKey(personNameToPrint)) {
            people.get(personNameToPrint).printInfo();
        }
    }
}
