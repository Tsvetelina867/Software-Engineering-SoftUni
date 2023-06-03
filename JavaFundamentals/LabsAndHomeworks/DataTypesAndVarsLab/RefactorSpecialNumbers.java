package DataTypesAndVarsLab;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        int sumDigits = 0;
        int num = 0;
        boolean isSpecial = false;

        for (int number = 1; number <= count; number++) {
            num = number;
            while (number > 0) {
                sumDigits += number % 10;
                number = number / 10;
            }
            isSpecial = (sumDigits == 5) || (sumDigits == 7) || (sumDigits == 11);
            if (isSpecial) {
                System.out.printf("%d -> True%n", num);
            } else {
                System.out.printf("%d -> False%n", num);
            }
            sumDigits = 0;
            number = num;
        }

    }
}
