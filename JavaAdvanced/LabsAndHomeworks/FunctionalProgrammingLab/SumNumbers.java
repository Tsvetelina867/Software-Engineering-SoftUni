package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Count = " + numbers.length);
        Function<int[], String> sumNumbers = arr -> "Sum = " + Arrays.stream(arr).sum();
        System.out.println(sumNumbers.apply(numbers));
    }
}
