package ExceptionsAndErrorHandlingLab;

import java.util.Optional;
import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = scanner.nextInt();
        int end = scanner.nextInt();
        System.out.printf("Range: [%d...%d]\n", start, end);
        scanner.nextLine();

        String value = scanner.nextLine();

        while (!validNumber(value, start, end)) {
            System.out.println("Invalid number: " + value);
            value = scanner.nextLine();
        }
        System.out.println("Valid number: " + value);
    }

    private static boolean validNumber(String value, int start, int end) {
        Optional<Integer> num = Optional.empty();
        try {
            num = Optional.of(Integer.parseInt(value));
        } catch (NumberFormatException ignored) {
        }
        return num.isPresent() && num.get() >= start && num.get()<= end;
    }
}
