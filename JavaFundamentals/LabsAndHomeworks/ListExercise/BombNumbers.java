package ListExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();
        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int num : sequence) {
            numbers.add(num);
        }

        int[] bombInfo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int bombNumber = bombInfo[0];
        int bombPower = bombInfo[1];

        while (numbers.contains(bombNumber)) {
            int bombIndex = numbers.indexOf(bombNumber);
            int startIndex = Math.max(0, bombIndex - bombPower);
            int endIndex = Math.min(numbers.size() - 1, bombIndex + bombPower);

            for (int i = endIndex; i >= startIndex; i--) {
                numbers.remove(i);
            }
        }

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        System.out.println(sum);
    }
}
