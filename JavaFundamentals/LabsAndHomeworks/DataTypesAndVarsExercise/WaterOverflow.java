package DataTypesAndVars;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = 255;
        int n = Integer.parseInt(scanner.nextLine());
        int overall = 0;

        for (int i = 0; i < n; i++) {
            int litres = Integer.parseInt(scanner.nextLine());
            overall += litres;
            if (overall > capacity) {
                System.out.println("Insufficient capacity!");
                overall -= litres;
            }
        }
        System.out.println(overall);
    }
}
