package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<StringBuilder> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] commandTokens = scanner.nextLine().split(" ");
            switch (commandTokens[0]) {
                case "1":
                    stack.push(new StringBuilder(sb));
                    String textToAppend = commandTokens[1];
                    sb.append(textToAppend);
                    break;
                case "2":
                    stack.push(new StringBuilder(sb));
                    int count = Integer.parseInt(commandTokens[1]);
                    sb.delete(sb.length() - count, sb.length());
                    break;
                case "3":
                    int index = Integer.parseInt(commandTokens[1]);
                    System.out.println(sb.charAt(index - 1));
                    break;
                case "4":
                    sb = new StringBuilder(stack.pop());
                    break;
            }
        }
    }
}
