package FunctionalProgrammingExercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Predicate<String> predicate;
        Map<String, Predicate<String>> predicatesMap = new HashMap<>();

        String line = scanner.nextLine();

        while (!line.equals("Print")) {
            String[] tokens = line.split(";");
            String name = line.substring(4);
            String nameToRemove = line.substring(7);
            String command = tokens[0];
            String parameter = tokens[2];

            if (command.equals("Add filter")) {
                switch (tokens[1]) {
                    case "Starts with":
                        predicate = s -> s.startsWith(parameter);
                        predicatesMap.putIfAbsent(name, predicate);
                        break;
                    case "Ends with":
                        predicate = s -> s.endsWith(parameter);
                        predicatesMap.putIfAbsent(name, predicate);
                        break;
                    case "Length":
                        predicate = s -> s.length() == Integer.parseInt(parameter);
                        predicatesMap.putIfAbsent(name, predicate);
                        break;
                    case "Contains":
                        predicate = s -> s.contains(parameter);
                        predicatesMap.putIfAbsent(name, predicate);
                        break;
                }

            } else {
                predicatesMap.remove(nameToRemove);
            }

            line = scanner.nextLine();
        }

        for (String name : names) {
            boolean isGoing = true;
            for (String entry : predicatesMap.keySet()) {
                if (predicatesMap.get(entry).test(name)) {
                    isGoing = false;
                    break;
                }
            }
            if (isGoing) {
                System.out.print(name + " ");
            }
        }
    }
}
