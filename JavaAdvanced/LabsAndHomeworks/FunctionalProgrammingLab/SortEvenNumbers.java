package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        Function<List<Integer>, String> format = list -> list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(format.apply(numbers));

        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());

        System.out.println(format.apply(sortedNumbers));
    }
}
