package MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> products = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")) {
            String[] commandTokens = command.split(" ");
            command = commandTokens[0];

            switch (command) {
                case "Urgent":
                    String productToAdd = commandTokens[1];
                    if (!products.contains(productToAdd)) {
                        products.add(0, productToAdd);
                    }
                    break;
                case "Unnecessary":
                    String productToRemove = commandTokens[1];
                    if (products.contains(productToRemove)) {
                        products.remove(String.valueOf(productToRemove));
                    }
                    break;
                case "Correct":
                    String oldProduct = commandTokens[1];
                    int indexOfOldProduct = products.indexOf(oldProduct);
                    String newProduct = commandTokens[2];
                    if (products.contains(oldProduct)) {
                        products.set(indexOfOldProduct, newProduct);
                    }
                    break;
                case "Rearrange":
                    String productToMove = commandTokens[1];
                    if (products.contains(productToMove)) {
                        products.remove(String.valueOf(productToMove));
                        products.add(productToMove);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println(String.join(", ", products));
    }
}
