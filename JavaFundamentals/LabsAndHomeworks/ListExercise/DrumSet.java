package ListExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> drumSet = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> initialPower = new ArrayList<>(drumSet);

        String command = scanner.nextLine();
        while (!command.equals("Hit it again, Gabsy!")) {
            int damage = Integer.parseInt(command);
            for (int i = 0; i < drumSet.size(); i++) {
                int element = drumSet.get(i);
                element -= damage;
                drumSet.set(i, element);
                if (element <= 0) {
                    int initialQuality = initialPower.get(i);
                    int price = initialQuality * 3;

                    if (price <= savings) {
                        savings -= price;
                        drumSet.set(i, initialQuality);

                    } else {
                        drumSet.remove(drumSet.get(i));
                        initialPower.remove(initialPower.get(i));
                        i--;
                    }
                }
            }

            command = scanner.nextLine();
        }

        for (Integer drum : drumSet) {
            System.out.print(drum + " ");
        }
        System.out.printf("%nGabsy has %.2flv.", savings);
    }
}