package DataTypesAndVars;

import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");

            long leftNum = Long.parseLong(numbers[0]);
            long rightNum = Long.parseLong(numbers[1]);

            long sumOfDigits = 0;
            if (leftNum > rightNum) {
                leftNum = Math.abs(leftNum);
                while (leftNum > 0) {
                    long currentDigit = leftNum % 10;
                    sumOfDigits += currentDigit;
                    leftNum /= 10;
                }
            } else {
                rightNum = Math.abs(rightNum);
                while (rightNum > 0) {
                    long currentDigit = rightNum % 10;
                    sumOfDigits += currentDigit;
                    rightNum /= 10;
                }
            }
            System.out.println(Math.abs(sumOfDigits));
        }
    }
}
