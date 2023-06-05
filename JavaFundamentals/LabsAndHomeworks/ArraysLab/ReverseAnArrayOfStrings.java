package ArraysLab;

import java.util.Scanner;

public class ReverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");

        for (int i = 0; i < array.length / 2; i++) {
            String frontElement = array[i];
            String endElement = array[array.length - i - 1];
            array[i] = endElement;
            array[array.length - i - 1] = frontElement;
        }

        for (String s : array) {
            System.out.print(s + " ");
        }
    }
}
