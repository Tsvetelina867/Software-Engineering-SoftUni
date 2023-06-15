package MethodsExercise;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        findTopNumbers(n);
    }

    public static boolean isDivisibleByEight(int number) {
        int sum = 0;
            while (number > 0) {
                int currDigit = number % 10;
                sum += currDigit;
                number /= 10;

        }
        if (sum % 8 == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean hasOddDigit(int number) {
        while (number > 0) {
            int currDigit = number % 10;
            if (currDigit % 2 != 0) {
                return true;
            }
            number /= 10;
        }
        return false;
    }

    public static void findTopNumbers(int n) {
        for (int number = 8; number <= n; number++) {
            if (isDivisibleByEight(number) && hasOddDigit(number)) {
                System.out.println(number);
            }
        }
    }
}
