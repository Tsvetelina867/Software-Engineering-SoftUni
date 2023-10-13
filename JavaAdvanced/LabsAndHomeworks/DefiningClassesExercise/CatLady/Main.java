package DefiningClassesExercise.CatLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Cat> cats = new ArrayList<>();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            double characteristic = Double.parseDouble(tokens[2]);
            Cat cat = null;
            switch (type) {
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, type, characteristic);
                    break;
                case "Siamese":
                    cat = new Siamese(name, type, characteristic);
                    break;
                case "Cymric":
                    cat = new Cymric(name, type, characteristic);
                    break;
            }
            cats.add(cat);
            line = scanner.nextLine();
        }
        String nameToPrint = scanner.nextLine();
        cats.stream().filter(cat -> cat.getName().equals(nameToPrint)).forEach(System.out::println);
    }
}
