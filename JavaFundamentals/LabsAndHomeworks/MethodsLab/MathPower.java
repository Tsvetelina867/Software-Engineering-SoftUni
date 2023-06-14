package MethodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());
        double power = Double.parseDouble(scanner.nextLine());
        double result = raiseNumber(num, power);

        DecimalFormat df = new DecimalFormat("0.###");

        System.out.println(df.format(result));
    }

    public static double raiseNumber(double number, double power) {
        double result = 1;
        for (int i = 1; i <= power; i++) {
            result = result * number;
        }
        return result;
    }
}
