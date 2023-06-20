package ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;

        while (!numbers.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            int removedElement = 0;
            if (index < 0) {
                removedElement = numbers.get(0);
                numbers.remove(0);
                numbers = modifyList(numbers, removedElement);
                if (!numbers.isEmpty()) {
                    int lastElement = numbers.get(numbers.size() - 1);
                    numbers.add(0, lastElement);
                }
            } else if (index > numbers.size() - 1) {
                removedElement = numbers.get(numbers.size() - 1);
                numbers.remove(numbers.size() - 1);
                numbers = modifyList(numbers, removedElement);
                if (!numbers.isEmpty()) {
                    int firstElement = numbers.get(0);
                    numbers.add(numbers.size(), firstElement);
                }
            } else {
                removedElement = numbers.get(index);
                numbers.remove(index);
                numbers = modifyList(numbers, removedElement);
            }
            sum += removedElement;
        }
        System.out.println(sum);

    }

    public static List<Integer> modifyList(List<Integer> numbers, int removedElement) {
        for (int i = 0; i < numbers.size(); i++) {
            Integer number = numbers.get(i);
            if (number <= removedElement) {
                numbers.set(i, number + removedElement);
            } else {
                numbers.set(i, number - removedElement);
            }
        }
        return numbers;
    }
}
