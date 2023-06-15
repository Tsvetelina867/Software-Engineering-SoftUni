package MethodsExercise;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        getSmallest(firstNumber, secondNumber, thirdNumber);
    }

    public static void getSmallest (int a, int b, int c) {
        if (a <= b && a < c) {
            System.out.println(a);
        } else if (b <= a && b < c) {
            System.out.println(b);
        } else {
            System.out.println(c);
        }
    }
}
