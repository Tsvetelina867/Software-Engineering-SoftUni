package FunctionalProgrammingExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> divisibleNums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        Predicate<Integer> predicate;

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        for (Integer number : numbers) {
            boolean isDivisible = true;
            for (Integer divisibleNum : divisibleNums) {
                predicate = num -> num % divisibleNum == 0;
                if (!predicate.test(number)) {
                    isDivisible = false;
                    break;
                }
            }
            if (isDivisible) {
                result.add(number);
            }
        }

        result.forEach(e -> System.out.print(e + " "));
    }


}
