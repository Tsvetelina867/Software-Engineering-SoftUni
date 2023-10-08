package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Integer[], Integer> findSmallestNum = arr -> {
            return Arrays.stream(arr)
                    .min(Integer::compare)
                    .get();
        };

        Integer[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Integer smallestNumber = findSmallestNum.apply(arr);
        System.out.println(smallestNumber);

    }
}
