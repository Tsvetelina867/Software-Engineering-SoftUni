package TextProcessingExercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] input = scanner.nextLine().split(" ");
        String firstStr = input[0];
        String secondStr = input[1];

        int length = Math.min(firstStr.length(), secondStr.length());
        int sum = 0;

        for (int i = 0; i < length; i++) {
            sum += firstStr.charAt(i) * secondStr.charAt(i);
        }


        for (int i = length; i < firstStr.length(); i++) {
            sum += firstStr.charAt(i);
        }

        for (int i = length; i < secondStr.length(); i++) {
            sum += secondStr.charAt(i);
        }

        System.out.println(sum);
    }
}
