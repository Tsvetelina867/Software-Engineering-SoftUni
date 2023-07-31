package MapsLambdaAndStreamAPILab;

import java.util.*;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] input = Arrays.stream(scanner.nextLine().split(" "))
                .filter(word -> word.length() % 2 == 0)
                .toArray(String[]::new);

        for (String string : input) {
            System.out.println(string);
        }


    }
}
