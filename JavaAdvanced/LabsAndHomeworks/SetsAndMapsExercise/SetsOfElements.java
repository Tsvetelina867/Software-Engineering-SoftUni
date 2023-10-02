package SetsAndMapsExercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];

        LinkedHashSet<String> firstDeck = new LinkedHashSet<>();
        LinkedHashSet<String> secondDeck = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            firstDeck.add(scanner.nextLine());
        }
        for (int i = 0; i < m; i++) {
            secondDeck.add(scanner.nextLine());
        }
        firstDeck.retainAll(secondDeck);
        System.out.println(String.join(" ", firstDeck));

    }
}
