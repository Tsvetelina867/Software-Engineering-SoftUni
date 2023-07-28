package ListExercise;

import java.util.Random;
import java.util.Scanner;

public class RandomSentenceGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = {"Peter", "Michell", "Jane", "Steve"};
        String[] places = {"Sofia", "Plovdiv", "Varna", "Burgas"};
        String[] verbs = {"eats", "holds", "sees", "plays with", "brings"};
        String[] nouns = {"stones", "cake", "apple", "laptop", "bikes"};
        String[] adverbs = {"slowly", "diligently", "warmly", "sadly", "rapidly"};
        String[] details = {"near the river", "at home", "in the park", "in the mall"};

        System.out.println("Hello, this is your first random-generated sentence: ");
        while (true) {
            String randomName = getRandomWord(names);
            String randomPlace = getRandomWord(places);
            String randomVerb = getRandomWord(verbs);
            String randomNoun = getRandomWord(nouns);
            String randomAdverb = getRandomWord(adverbs);
            String randomDetail = getRandomWord(details);

            System.out.printf("%s from %s %s %s %s %s%n", randomName, randomPlace, randomAdverb, randomVerb, randomNoun, randomDetail);
            System.out.println("Type 'hint' for the next word category, or press [Enter] to generate a new sentence.");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("hint")) {
                String categoryHint = getRandomWord(new String[]{"name", "place", "verb", "noun", "adverb", "detail"});
                System.out.println("Next word category: " + categoryHint);
            } else {
                System.out.println("Click [Enter] to generate a new sentence or type 'exit' to stop.");
                input = scanner.nextLine().trim().toLowerCase();
                if (input.equals("exit")) {
                    break;
                }
            }
        }
    }

    public static String getRandomWord(String[] words) {
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        String word = words[randomIndex];
        return word;
    }
}