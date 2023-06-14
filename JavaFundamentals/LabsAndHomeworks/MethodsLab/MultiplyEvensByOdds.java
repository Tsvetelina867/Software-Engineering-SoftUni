package MethodsLab;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Math.abs(Integer.parseInt(scanner.nextLine()));

        System.out.println(multiply(num));

    }
    public static int getEvenSum(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;

            if (digit % 2 == 0) {
                sum += digit;
            }
            num /= 10;
        }
        return sum;
    }
    public static int getOddSum(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;

            if (digit % 2 != 0) {
                sum += digit;
            }
            num /= 10;
        }
        return sum;
    }
    public static int multiply(int num) {
        int oddSum = getOddSum(num);
        int evenSum = getEvenSum(num);
        return evenSum * oddSum;
    }
}
