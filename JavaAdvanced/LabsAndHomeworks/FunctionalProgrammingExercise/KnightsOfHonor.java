package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> addingSir = s -> System.out.println("Sir " + s);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(addingSir);
    }
}
