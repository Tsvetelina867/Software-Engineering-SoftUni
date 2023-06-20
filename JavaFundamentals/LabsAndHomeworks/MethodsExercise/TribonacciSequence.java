package MethodsExercise;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        printTribonacciSequence(num);
    }

    public static void printTribonacciSequence(int num) {
        int first = 1;
        int second = 1;
        int third = 2;

        if (num > 3) {

            System.out.print(first + " ");
            System.out.print(second + " ");
            System.out.print(third + " ");

            for (int i = 3; i < num; i++) {
                int next = first + second + third;
                System.out.print(next + " ");

                first = second;
                second = third;
                third = next;
            }
        } else if (num == 2) {
            System.out.print(first + " " + second);
        } else if (num == 1) {
            System.out.println(first);
        }


    }
}
