package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> books = Arrays.stream(scanner.nextLine().split("&"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while(!command.equals("Done")) {
            String[] commandTokens = command.split(" \\| ");
            command = commandTokens[0];

            switch (command) {
                case "Add Book":
                    String bookToAdd = commandTokens[1];
                    if (!books.contains(bookToAdd)) {
                        books.add(0, bookToAdd);
                    }
                    break;

                case "Take Book":
                    String bookToRemove = commandTokens[1];
                    if (books.contains(bookToRemove)) {
                        books.remove(String.valueOf(bookToRemove));
                    }
                    break;

                case "Swap Books":
                    String firstBook = commandTokens[1];
                    int indexFirstBook = books.indexOf(firstBook);
                    String secondBook = commandTokens[2];
                    int indexSecondBook = books.indexOf(secondBook);
                    if (books.contains(firstBook) && books.contains(secondBook)) {
                        books.set(indexFirstBook, secondBook);
                        books.set(indexSecondBook, firstBook);
                    }
                    break;

                case "Insert Book":
                    String bookToInsert = commandTokens[1];
                    if (!books.contains(bookToInsert)) {
                        books.add(bookToInsert);
                    }
                    break;

                case "Check Book":
                    int index = Integer.parseInt(commandTokens[1]);
                    if (index >= 0 && index < books.size()) {
                        System.out.println(books.get(index));
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println(String.join(", ", books));

    }
}
