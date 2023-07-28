package ListExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String text = scanner.nextLine();
        List<Character> result = getCharsFromText(numbers, text);
        System.out.println(result.toString().replaceAll("[\\[\\], ]", ""));
    }

    public static List<Character> getCharsFromText(List<Integer> numbers, String text) {
        List<Character> result = new ArrayList<>();

        int textLength = text.length();

        for (int number : numbers) {
            int sumOfDigits = calculateSumOfDigits(number);

            char character = text.charAt(sumOfDigits % textLength);
            result.add(character);

            text = text.substring(0, sumOfDigits % textLength) +
                    text.substring(sumOfDigits % textLength + 1);
            textLength--;
        }

        return result;
    }

    public static int calculateSumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

}
