package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        String command = scanner.nextLine();

        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (stack.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        System.out.println("no previous URLs");
                    } else {
                        System.out.println(stack.peek());
                    }
                }
            } else {
                stack.push(command);
                System.out.println(command);
            }
            command = scanner.nextLine();
        }
    }
}
