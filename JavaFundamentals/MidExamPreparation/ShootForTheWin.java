package MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();
        int shotTargets = 0;

        while (!command.equals("End")) {
            int index = Integer.parseInt(command);

            if (index >= 0 && index < targets.length) {
                int currentTarget = targets[index];
                targets[index] = -1;
                shotTargets++;

                for (int i = 0; i < targets.length; i++) {
                    if (targets[i] == - 1) {
                        continue;
                    }
                    if (targets[i] > currentTarget && targets[i] != -1) {
                        targets[i] -= currentTarget;
                    } else if (targets[i] <= currentTarget && targets[i] != -1){
                        targets[i] += currentTarget;
                    }
                }

            }
            command = scanner.nextLine();
        }

        System.out.print("Shot targets: " + shotTargets + " -> " + Arrays.toString(targets).replaceAll("\\[","").replaceAll("]","").replaceAll(",", ""));
    }
}
