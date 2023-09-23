package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] tokens = scanner.nextLine().split("\\s+");
        Collections.addAll(stack, tokens);

        while (stack.size() > 1) {
            int firstNum = Integer.parseInt(stack.pop());
            String operand = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            if (operand.equals("+")) {
                stack.push(String.valueOf(firstNum + secondNum));
            } else if (operand.equals("-")) {
                stack.push(String.valueOf(firstNum - secondNum));
            }
        }

        System.out.println(stack.peek());
    }
}
