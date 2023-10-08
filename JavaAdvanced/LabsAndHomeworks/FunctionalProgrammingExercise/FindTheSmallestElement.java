package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<List<Integer>, Integer> findSmallest = list -> list.stream()
                .min(Integer::compare)
                .get();

        List<Integer> arr = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int smallestNumber = findSmallest.apply(arr);

        int indexOfSmallest = arr.lastIndexOf(smallestNumber);
        System.out.println(indexOfSmallest);
    }
}
