package BasicSyntaxLab;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int biggest = num1;
        int smallest = num2;
        int middle = num3;

        if (biggest < num2 && num2 > num3) {
            biggest = num2;
            if (num1 < num3) {
                smallest = num1;
            } else {
                smallest = num3;
                middle = num1;
            }
        } else if (biggest < num3 && num3 > num2) {
            biggest = num3;
            if (num1 > num2) {
                middle = num1;
            } else {
                middle = num2;
                smallest = num1;
            }
        } else if (biggest > num2 && biggest > num3) {
            if (num2 > num3) {
                middle = num2;
                smallest = num3;
            }
        }

        System.out.println(biggest);
        System.out.println(middle);
        System.out.println(smallest);

    }
}
