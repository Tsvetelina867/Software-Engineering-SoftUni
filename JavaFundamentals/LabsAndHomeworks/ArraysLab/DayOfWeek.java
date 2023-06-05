package ArraysLab;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dayOfWeek = Integer.parseInt(scanner.nextLine());
        String[] daysOfWeek = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };
        if (dayOfWeek > 0 && dayOfWeek < 8) {
            System.out.println(daysOfWeek[dayOfWeek - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
