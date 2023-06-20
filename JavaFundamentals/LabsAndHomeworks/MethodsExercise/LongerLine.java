package MethodsExercise;

import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double x3 = Double.parseDouble(scanner.nextLine());
        double y3 = Double.parseDouble(scanner.nextLine());
        double x4 = Double.parseDouble(scanner.nextLine());
        double y4 = Double.parseDouble(scanner.nextLine());

        double lineA = calculateLineLength(x1, y1, x2, y2);
        double lineB = calculateLineLength(x3, y3, x4, y4);

        if (lineA >= lineB && checkCloserPoint(x1, y1, x2, y2)) {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x1, y1, x2, y2);
        } else if (lineA >= lineB && !checkCloserPoint(x1, y1, x2, y2)) {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x2, y2, x1, y1);
        } else if (lineA < lineB && checkCloserPoint(x3, y3, x4, y4)) {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x3, y3, x4, y4);
        } else if (lineA < lineB && !checkCloserPoint(x3, y3, x4, y4)) {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x4, y4, x3, y3);
        }
    }

    private static boolean checkCloserPoint(double x1, double y1, double x2, double y2) {
        boolean isCloserToZero = false;
        double dist1 = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
        double dist2 = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));
        if (dist1 <= dist2) {
            isCloserToZero = true;
        }
        return isCloserToZero;
    }

    private static double calculateLineLength(double x1, double y1, double x2, double y2) {
        double lineLength = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return lineLength;
    }
}

