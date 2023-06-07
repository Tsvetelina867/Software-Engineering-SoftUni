package ArraysExercise;
import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());

        int[] ladybugIndexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] field = new int[fieldSize];

        for (int index : ladybugIndexes) {
            if (index >= 0 && index < fieldSize) {
                field[index] = 1;
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] tokens = command.split("\\s+");
            int ladybugIndex = Integer.parseInt(tokens[0]);
            String direction = tokens[1];
            int flyLength = Integer.parseInt(tokens[2]);

            if (ladybugIndex >= 0 && ladybugIndex < fieldSize && field[ladybugIndex] == 1) {
                field[ladybugIndex] = 0;

                int newPosition = direction.equals("right") ? ladybugIndex + flyLength : ladybugIndex - flyLength;

                while (newPosition >= 0 && newPosition < fieldSize) {
                    if (field[newPosition] == 0) {
                        field[newPosition] = 1;
                        break;
                    }
                    newPosition = direction.equals("right") ? newPosition + flyLength : newPosition - flyLength;
                }
            }

            command = scanner.nextLine();
        }

        for (int cell : field) {
            System.out.print(cell + " ");
        }
    }
}
