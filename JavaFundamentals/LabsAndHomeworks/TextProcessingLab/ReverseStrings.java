package TextProcessingLab;


import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        while (!(input = scanner.nextLine()).equals("end")) {
            StringBuilder reversed = new StringBuilder();
            for (int i = input.length() - 1; i >= 0 ; i--) {
                reversed.append(input.charAt(i));

            }
            System.out.printf("%s = %s%n", input, reversed);
        }
    }
}
