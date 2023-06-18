package MidExam;

import java.util.Scanner;

public class ExperienceGaining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededExperience = Double.parseDouble(scanner.nextLine());
        int countOfBattles = Integer.parseInt(scanner.nextLine());

        double totalExperience = 0.0;

        for (int i = 1; i <= countOfBattles; i++) {
            double currentExperience = Double.parseDouble(scanner.nextLine());

            if (i % 3 == 0) {
                currentExperience += currentExperience * 0.15;
            }
            if (i % 5 == 0) {
                currentExperience -= currentExperience * 0.1;
            }
            if (i % 15 == 0) {
               currentExperience +=  currentExperience * 0.05;
            }
            totalExperience += currentExperience;

            if (totalExperience >= neededExperience) {
                System.out.printf("Player successfully collected his needed experience for %d battles.%n", i);
                return;
            }

        }

        double leftExperienceToGain = neededExperience - totalExperience;
        System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", leftExperienceToGain);
    }
}
