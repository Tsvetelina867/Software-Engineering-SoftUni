package DataTypesAndVars;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int yield = startingYield;
        int spicesADay = 0;
        int days = 0;
        int spices = 0;

        while (yield >= 100) {
            spicesADay = yield;
            spices += spicesADay;
            yield -= 10;
            spices -= 26;
            days++;
        }
        spices -= 26;
        if (spices < 0) {
            spices = 0;
        }
        System.out.println(days);
        System.out.println(spices);
    }
}
