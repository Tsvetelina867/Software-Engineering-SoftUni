package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            if (input.contains("swap")) {
            int index1 = Integer.parseInt(input.split(" ")[1]);
            int index2 = Integer.parseInt(input.split(" ")[2]);
            int firstNumber = array[index1];
            int secondNumber = array[index2];
            array[index1] = secondNumber;
            array[index2] = firstNumber;

            } else if (input.contains("multiply")) {
                int index1 = Integer.parseInt(input.split(" ")[1]);
                int index2 = Integer.parseInt(input.split(" ")[2]);
                int product = array[index1] * array[index2];
                array[index1] = product;

            } else if (input.equals("decrease")) {
                for (int i = 0; i < array.length; i++) {
                    array[i]--;
                }
            }
            input = scanner.nextLine();
        }

        System.out.println(Arrays.toString(array).replace("[", "").replace("]", ""));
    }
}
