package RegexExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] tickets = input.split("[, ]+");

        for (String ticket : tickets) {
            if (ticket.length() == 20) {
                String leftHalf = ticket.substring(0, 10);
                String rightHalf = ticket.substring(10, 20);

                String leftMatch = "a";
                String rightMatch = "s";

                Pattern pattern = Pattern.compile("[\\\\@]{6,}|[\\\\$]{6,}|[\\\\#]{6,}|[\\\\^]{6,}");
                Matcher leftMatcher = pattern.matcher(leftHalf);
                Matcher rightMatcher = pattern.matcher(rightHalf);

                if (leftMatcher.find()) {
                    leftMatch = leftMatcher.group();
                }

                if (rightMatcher.find()) {
                    rightMatch = rightMatcher.group();
                }

                if (leftMatch.substring(0, 1).equals(rightMatch.substring(0, 1))) {
                    int matchCount = Math.min(leftMatch.length(), rightMatch.length());

                    if (matchCount == 10) {
                        System.out.printf("ticket \"%s\" - %d%s Jackpot!%n", ticket, matchCount, leftMatch.charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - %d%s%n", ticket, matchCount, leftMatch.charAt(0));
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                }

            } else {
                System.out.println("invalid ticket");
            }
        }

    }
}
