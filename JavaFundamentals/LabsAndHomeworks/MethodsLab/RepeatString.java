package MethodsLab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(repeatInput(input, n));

    }

    public static String repeatInput(String text, int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += text;
        }
        return result;
    }
}
