package MethodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNum = Double.parseDouble(scanner.nextLine());
        String operator = scanner.nextLine();
        double secondNum = Double.parseDouble(scanner.nextLine());

        double result = calculate(firstNum, operator, secondNum);
        DecimalFormat df = new DecimalFormat("0.##");
        System.out.printf(df.format(result));

    }

    public static double calculate(double first, String operator, double second) {
        switch (operator) {
            case "+":
                return first + second;
            case "*":
                return first * second;
            case "/":
                return first / second;
            case "-":
                return first - second;
        }
        return 0;
    }
}

