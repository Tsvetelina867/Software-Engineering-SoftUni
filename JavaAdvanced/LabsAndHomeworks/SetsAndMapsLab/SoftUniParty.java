package SetsAndMapsLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> regularGuests = new TreeSet<>();
        Set<String> vipGuests = new TreeSet<>();

        String input = scanner.nextLine();
        while (!"PARTY".equals(input)) {
            if (Character.isDigit(input.charAt(0))) {
                vipGuests.add(input);
            } else {
                regularGuests.add(input);
            }
            input = scanner.nextLine();
        }

        while (!"END".equals(input)) {
            if (vipGuests.contains(input)) {
                vipGuests.remove(input);
            } else {
                regularGuests.remove(input);
            }

            input = scanner.nextLine();
        }
        System.out.println(vipGuests.size() + regularGuests.size());

        for (String vipGuest : vipGuests) {
            System.out.println(vipGuest);
        }
        for (String regularGuest : regularGuests) {
            System.out.println(regularGuest);
        }
    }
}
