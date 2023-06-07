package ArraysExercise;

import javax.lang.model.type.IntersectionType;
import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lengthDNA = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        int lineCount = 0;
        int bestStartIndex = Integer.MAX_VALUE;
        int[] bestSequence = new int[lengthDNA];
        int bestSequenceNum = 0;
        int bestOnes = 0;
        int bestSum = 0;
        int sum = 0;

        while (!"Clone them!".equals(command)) {

            int[] currentLine = Arrays.stream(command.split("!+"))
                    .mapToInt(Integer::parseInt).toArray();

            lineCount++;
            int longestOnesInARow = 0;
            int startIndex = Integer.MAX_VALUE;

            for (int i = 0; i < currentLine.length; i++) {
                int onesInARow = 0;
                for (int j = i; j < currentLine.length; j++) {
                    if (currentLine[i] == currentLine[j] && currentLine[i] == 1) {
                        onesInARow++;
                        if (onesInARow > longestOnesInARow) {
                            longestOnesInARow = onesInARow;
                            startIndex = i;
                        }
                    } else {
                        break;
                    }
                }
            }

            if (longestOnesInARow > bestOnes) {
                bestOnes = longestOnesInARow; //ъпдейтваме най-добрата последователност от 1-ци от всички редове до момента
                bestSequence = currentLine;
                bestSequenceNum = lineCount;
                bestStartIndex = startIndex; //най-добрия индекс 1-ци
            } else if (longestOnesInARow == bestOnes) {
                if (startIndex < bestStartIndex) {
                    bestSequence = currentLine;
                    bestSequenceNum = lineCount;
                    bestStartIndex = startIndex;
                } else if (startIndex == bestStartIndex) { //при равни посл. 1-ци и индекси проверяваме сумите на текущия и най-добрия до момента ред
                    for (int i = 0; i < bestSequence.length; i++) {
                        bestSum += bestSequence[i];
                    }
                    for (int i = 0; i < currentLine.length; i++) {
                        sum += currentLine[i];
                    }
                    if (sum > bestSum) {
                        bestSequence = currentLine;
                        bestSequenceNum = lineCount;
                        bestSum = sum;
                    }
                }
            }

            command = scanner.nextLine();
        }

        bestSum = 0;
        for (int i = 0; i < bestSequence.length; i++) {
            bestSum += bestSequence[i];
        }


        if (bestSum == 0) {
            bestSequenceNum = 1;
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSequenceNum, bestSum);
        for (int i : bestSequence) {
            System.out.print(i + " ");
        }
    }
}
