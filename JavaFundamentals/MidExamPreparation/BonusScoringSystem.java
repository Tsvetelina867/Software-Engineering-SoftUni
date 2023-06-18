package MidExamPreparation;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int numberOfLectures = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());
        double maxBonus = 0;
        int maxAttendances = 0;

        for (int i = 0; i < n; i++) {
            int currentAttendances = Integer.parseInt(scanner.nextLine());
            double currentBonus = currentAttendances *1.0 / numberOfLectures * (5 + bonus);
            if (currentBonus > maxBonus) {
                maxBonus = currentBonus;
                maxAttendances = currentAttendances;
            }
        }
        maxBonus = Math.ceil(maxBonus);

        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.", maxAttendances);
    }
}
