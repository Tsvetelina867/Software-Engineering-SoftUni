package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int firstIndex = 0;
        int lastIndex = 0;
        int longestSequence = 0;

        for (int index = 0; index < array.length - 1; index++) {
            int currentSequence = 0;
            if (array[index] == array[index + 1]) {
                currentSequence += 2;
                for (int j = index + 2; j < array.length; j++) {
                    if (array[index] == array[j]) {
                        currentSequence++;
                    } else {
                        break;
                    }
                }
            }
            if (currentSequence > longestSequence) {
                longestSequence = currentSequence;
                firstIndex = index;
                lastIndex = firstIndex + longestSequence;
            }
        }
        for (int i = firstIndex; i < lastIndex; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
