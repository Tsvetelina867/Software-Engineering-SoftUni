package ObjectsAndClassesLab;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] wordsArr = input.split(" ");
        Random rnd = new Random();

        for (int i = 0; i < wordsArr.length; i++) {
            int rndIndexX = rnd.nextInt(wordsArr.length);
            int rndIndexY = rnd.nextInt(wordsArr.length);

            String oldWord = wordsArr[rndIndexX];
            wordsArr[rndIndexX] = wordsArr[rndIndexY];
            wordsArr[rndIndexY] = oldWord;
        }

        System.out.println(String.join(System.lineSeparator(), wordsArr));
    }
}
