package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;

        for (int i = 0; i < expression.length(); i++) {
            char currentSymbol = expression.charAt(i);
            if (currentSymbol == '[' || currentSymbol == '{' || currentSymbol == '(') {
                stack.push(currentSymbol);
            } else if (currentSymbol == ']' || currentSymbol == '}' || currentSymbol == ')') {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char top = stack.pop();
                if ((currentSymbol == ']' && top != '[') ||
                        (currentSymbol == '}' && top != '{') ||
                        (currentSymbol == ')' && top != '(')) {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (isBalanced && stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
