package RegexExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalSum = 0;
        String regex = ">>([A-Z]+[a-z]*)<<(\\d+.\\d*)!(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        System.out.println("Bought furniture:");

        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String furnitureName = matcher.group(1);
                double price = Double.parseDouble(matcher.group(2));
                int quantity = Integer.parseInt(matcher.group(3));
                double sum = price * quantity;
                totalSum += sum;
                System.out.println(furnitureName);
            }
            input = scanner.nextLine();
        }

        System.out.printf("Total money spend: %.2f", totalSum);
    }
}
