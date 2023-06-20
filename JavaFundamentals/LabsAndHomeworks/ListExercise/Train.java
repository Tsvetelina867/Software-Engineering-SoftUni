package ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while(!command.equals("end")) {
            String[] commandTokens = command.split(" ");
            if (command.contains("Add")) {
                int newWagon = Integer.parseInt(commandTokens[1]);
                wagons.add(newWagon);
            } else {
                int peopleToFit = Integer.parseInt(commandTokens[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    int currentWagon = wagons.get(i);
                    if (currentWagon + peopleToFit <= maxCapacity) {
                        currentWagon += peopleToFit;
                        wagons.set(i, currentWagon);
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }

        for (Integer wagon : wagons) {
            System.out.print(wagon + " ");
        }

    }
}
