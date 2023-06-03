package BasicSyntaxLab;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());

        if (multiplier < 11) {
            for (int i = multiplier; i <= 10; i++) {
                int product = num * i;
                System.out.printf("%d X %d = %d\n", num, i, product);
            }
        } else {
            System.out.printf("%d X %d = %d", num, multiplier, num * multiplier);
        }
    }
}
