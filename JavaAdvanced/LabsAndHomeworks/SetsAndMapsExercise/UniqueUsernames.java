package SetsAndMapsExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> words = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            words.add(input);
        }

        words.forEach(System.out::println);
    }
}
