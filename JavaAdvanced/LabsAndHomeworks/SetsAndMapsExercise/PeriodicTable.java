package SetsAndMapsExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            elements.addAll(Arrays.asList(scanner.nextLine().split(" ")));
        }

        System.out.println(String.join(" ", elements));
    }
}
