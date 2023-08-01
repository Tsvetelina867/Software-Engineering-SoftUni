package TextProcessingExercise;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); //"abv>1>1>2>2asdasd"
        StringBuilder sb = new StringBuilder(input); //"abv>1>1>2>2asdasd"

        int totalStrength = 0;
        for (int position = 0; position <= sb.length() - 1; position++) {
            char currentSymbol = sb.charAt(position);
            if (currentSymbol == '>') {
                int explosionStrength = Integer.parseInt(sb.charAt(position + 1) + "");
                totalStrength += explosionStrength;
            } else if (currentSymbol != '>' && totalStrength > 0){
                sb.deleteCharAt(position);
                totalStrength--;
                position--;
            }
        }

        System.out.println(sb);
    }
}
