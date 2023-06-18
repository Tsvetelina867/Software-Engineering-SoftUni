package MidExamPreparation;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalEfficiencyPerHour = 0;
        for (int i = 0; i < 3; i++) {
            int efficiencyPerPerson = Integer.parseInt(scanner.nextLine());
            totalEfficiencyPerHour += efficiencyPerPerson;
        }

        int studentsCount = Integer.parseInt(scanner.nextLine());
        int hours = 0;

        while (studentsCount > 0) {
            hours++;

            if (hours % 4 == 0) {
                continue;
            }
            studentsCount -= totalEfficiencyPerHour;
        }

        System.out.printf("Time needed: %dh.", hours);
    }
}
