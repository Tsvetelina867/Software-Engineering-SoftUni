package DataTypesAndVars;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int startingPower = power;
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int targets = 0;

        while (power >= distance) {
            power -= distance;
            targets++;
            if (power == startingPower/ 2 && exhaustionFactor != 0) {
                power /= exhaustionFactor;
            }
        }

        System.out.println(power);
        System.out.println(targets);

    }
}
