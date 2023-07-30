package RegularFinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String bossNameRegex = "^\\|([A-Z]{4,})\\|$";
        String titleRegex = "^#([a-zA-Z]+\\s[a-zA-Z]+)#$";
        Pattern patternBoss = Pattern.compile(bossNameRegex);
        Pattern patternTitle = Pattern.compile(titleRegex);



        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(":");
            if (input.length == 2) {
                String bossName = input[0];
                String title = input[1];

                Matcher matcherBoss = patternBoss.matcher(bossName);
                Matcher matcherTitle = patternTitle.matcher(title);

                if (matcherBoss.find() && matcherTitle.find()) {
                    String boss = matcherBoss.group(1);
                    String titleName = matcherTitle.group(1);

                    System.out.printf("%s, The %s%n", boss, titleName);
                    System.out.println(">> Strength: " + boss.length());
                    System.out.println(">> Armor: " + titleName.length());
                } else {
                    System.out.println("Access denied!");
                }
            } else {
                System.out.println("Access denied!");
            }

        }

    }
}
