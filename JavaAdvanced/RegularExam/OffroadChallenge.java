package RegularExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class OffroadChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> initialFuelStack = new ArrayDeque<>();
        Deque<Integer> additionalConsumptionQueue = new ArrayDeque<>();
        Deque<Integer> fuelNeededQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(initialFuelStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(additionalConsumptionQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(fuelNeededQueue::offer);
        int altitudes = 0;
        int reachedAltitudes = 0;

        boolean isClimbing = true;
        while (isClimbing && reachedAltitudes < 4) {
            int usedFuel = initialFuelStack.getFirst();
            int consumption = additionalConsumptionQueue.getFirst();
            int neededFuel = fuelNeededQueue.getFirst();
            altitudes++;

            if (usedFuel - consumption >= neededFuel) {
                initialFuelStack.pop();
                additionalConsumptionQueue.poll();
                fuelNeededQueue.poll();
                System.out.println("John has reached: Altitude " + altitudes);
                reachedAltitudes++;
            } else if (usedFuel - consumption < neededFuel) {
                isClimbing = false;
                System.out.println("John did not reach: Altitude " + altitudes);
            }
        }

        if (reachedAltitudes > 0 && reachedAltitudes < 4) {
            System.out.println("John failed to reach the top.");
            System.out.print("Reached altitudes: ");
            for (int i = 1; i < reachedAltitudes; i++) {
                System.out.print("Altitude " + i + ", ");
            }
            System.out.print("Altitude " + reachedAltitudes);
        } else if (reachedAltitudes == 0) {
            System.out.println("John failed to reach the top.");
            System.out.println("John didn't reach any altitude.");
        } else if (reachedAltitudes == 4) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        }

    }
}