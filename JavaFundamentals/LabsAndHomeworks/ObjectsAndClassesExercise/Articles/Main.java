package ObjectsAndClassesExercise.Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputTokens = input.split(", ");
        String title = inputTokens[0];
        String content = inputTokens[1];
        String author = inputTokens[2];
        Article article = new Article(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            String[] commandTokens = command.split(": ");
            command = commandTokens[0];

            switch (command) {
                case "Edit":
                    String newContent = commandTokens[1];
                    article.Edit(newContent);
                    break;
                case "ChangeAuthor":
                    String newAuthor = commandTokens[1];
                    article.ChangeAuthor(newAuthor);
                    break;
                case "Rename":
                    String newTitle = commandTokens[1];
                    article.Rename(newTitle);
                    break;
            }
        }

        System.out.println(article.toString());
    }
}
