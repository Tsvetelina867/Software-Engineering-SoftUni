package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        Predicate<String> predicate;

        while (!command.equals("Party!")) {
            String[] tokens = command.split("\\s+");
            String action = tokens[0];
            String option = tokens[1];
            String criteria = tokens[2];

            if (option.equals("StartsWith")) {
                predicate = s -> s.startsWith(criteria);
            } else if (option.equals("EndsWith")) {
                predicate = s -> s.endsWith(criteria);
            } else {
                predicate = s -> s.length() == Integer.parseInt(criteria);
            }
            if (action.equals("Remove")) {
                names.removeIf(predicate);
            } else {
                List<String> guestsToDouble = names.stream()
                        .filter(predicate)
                        .collect(Collectors.toList());
                names.addAll(guestsToDouble);
            }

            command = scanner.nextLine();
        }

        Collections.sort(names);
        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(String.join(", ", names) + " are going to the party!");
        }
    }
}
