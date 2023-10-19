package IteratorsAndComparatorsExercise.Froggy;

import IteratorsAndComparatorsExercise.Froggy.Lake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       List<Integer> input = Arrays.stream(scanner.nextLine().split("[, ]+ "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
       Lake lake = new Lake(input);

        List<String> numberStrings = new ArrayList<>();
        for (Integer number : lake) {
            numberStrings.add(number.toString());
        }

        System.out.println(String.join(", ", numberStrings));

    }
}
