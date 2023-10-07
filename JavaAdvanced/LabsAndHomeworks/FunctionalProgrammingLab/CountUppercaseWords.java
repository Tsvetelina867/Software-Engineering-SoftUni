package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] words = line.split("\\s+");

        Predicate<String> isUppercase = l -> Character.isUpperCase(l.charAt(0));

        Function<String[], List<String>> getUppercaseWords = arr -> Arrays.stream(arr)
                .filter(isUppercase)
                .collect(Collectors.toList());

        List<String> uppercaseWords = getUppercaseWords.apply(words);
        System.out.println(uppercaseWords.size());
        Consumer<String> outputConsumer = System.out::println;

        uppercaseWords.forEach(outputConsumer);


    }
}
