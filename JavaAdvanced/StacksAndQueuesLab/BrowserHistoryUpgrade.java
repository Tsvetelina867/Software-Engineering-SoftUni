package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> forwardStack = new ArrayDeque<>();
        String command = scanner.nextLine();

        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (stack.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forwardStack.addFirst(stack.peek());
                    stack.pop();
                    System.out.println(stack.peek());
                }
            } else if (command.equals("forward")) {
                if (forwardStack.size() < 1) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forwardStack.peek());
                    stack.push(forwardStack.pop());
                }
            } else {
                System.out.println(command);
                stack.push(command);
                forwardStack.clear();
            }
            command = scanner.nextLine();
        }
    }
}
