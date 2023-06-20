package MethodsExercise;

import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        printClosestPoint(x1, y1, x2, y2);
    }

    public static void printClosestPoint(int x1, int y1, int x2, int y2) {
        int distance1 = calculateDistance(x1, y1);
        int distance2 = calculateDistance(x2, y2);

        if (distance1 <= distance2) {
            System.out.printf("(%d, %d)", x1, y1);
        } else {
            System.out.printf("(%d, %d)", x2, y2);
        }
    }

    public static int calculateDistance(int x, int y) {
        int distance = x * x + y * y;
        return distance;
    }

}
