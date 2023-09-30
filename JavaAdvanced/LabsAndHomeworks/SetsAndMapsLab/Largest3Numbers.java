package SetsAndMapsLab;

import java.util.*;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        int count = 0;
        for (Integer number : numbers) {
            System.out.print(number + " ");
            count++;
            if (count == 3) {
                break;
            }
        }
    }
}
