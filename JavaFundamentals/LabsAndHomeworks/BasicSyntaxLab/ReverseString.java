package BasicSyntaxLab;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String reversed = "";

        for (int i = text.length() - 1; i >= 0 ; i--) {
            char currentSymbol = text.charAt(i);
            reversed += currentSymbol;
        }
        System.out.println(reversed);
    }
}
