package ObjectsAndClassesLab;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int factorial = Integer.parseInt(scanner.nextLine());
        BigInteger fact = new BigInteger("1");

        for (int i = 1; i <= factorial; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        System.out.println(fact);
    }
}
