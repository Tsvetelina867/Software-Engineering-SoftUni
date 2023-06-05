package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int[] codes = new int [n];

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("");

            for (int index = 0; index < input.length; index++) {
                String stringSymbol = input[index];
                char letter = stringSymbol.charAt(0);


                if (isVowel(letter)) {
                    sum += (int) letter * input.length ;

                }else
                {
                    sum += (int) letter / input.length ;
                }

                if (index == input.length -1) {
                    codes[i] = sum;
                    sum = 0;
                }
            }


            if (i == codes.length -1) {
                for (int j = 0; j < codes.length ; j++) {
                    Arrays.sort(codes);
                    System.out.println(codes[j]);
                }




            }
        }
    }

    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    public static boolean isConsonant (char c) {
        return "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(c) != -1;
    }
}