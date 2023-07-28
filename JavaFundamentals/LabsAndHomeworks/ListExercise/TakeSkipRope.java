package ListExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        List<String> nonNumbers = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        for (char i = 0; i < message.length(); i++) {
            char currentSymbol = message.charAt(i);
            if (!Character.isDigit(currentSymbol)) {
                nonNumbers.add(currentSymbol + "");
            } else {
                numbers.add((int) currentSymbol - '0');
            }
        }

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbers.get(i));
            } else {
                skipList.add(numbers.get(i));
            }
        }

        List<String> result = new ArrayList<>();
        int nonNumbersIndex = 0;

        for (int i = 0; i < numbers.size(); i += 2) {
            int takeCount = numbers.get(i);
            int skipCount = numbers.get(i + 1);

            for (int j = 0; j < takeCount; j++) {
                if (nonNumbersIndex < nonNumbers.size()) {
                    result.add(nonNumbers.get(nonNumbersIndex));
                }
                nonNumbersIndex++;
            }

            nonNumbersIndex += skipCount;
        }

        String decryptedMessage = "";
        for (String str : result) {
            decryptedMessage += str;
        }

        System.out.println(decryptedMessage);

    }
}
