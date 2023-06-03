package BasicSyntaxLab;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());



        for (int i = 0; i < n; i++) {
            int code = Integer.parseInt(scanner.nextLine());
            String numberAsText = Integer.toString(code);
            int digitsCount = numberAsText.length();
            int mainDigit = code % 10;
            int offset = (mainDigit - 2) * 3;
            if (mainDigit == 8 || mainDigit == 9) {
                offset++;
            }
            int letterIndex = offset + digitsCount - 1;
            if(code == 0) {
                System.out.print(" ");
            } else {
                System.out.print((char)(letterIndex + 97));
            }
        }
    }
}
