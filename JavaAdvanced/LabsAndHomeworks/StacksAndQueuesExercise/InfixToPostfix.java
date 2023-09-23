package StacksAndQueuesExercise;

import java.util.*;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> operators = new ArrayDeque<>();
        ArrayDeque<String> expression = new ArrayDeque<>();
        Map<String,Integer> precendence = new HashMap<>();
        precendence.put("*", 3);
        precendence.put("/", 3);
        precendence.put("+", 2);
        precendence.put("-", 2);
        precendence.put("(", 1);

        for (String anInput : input) {
            try {
                double num = Double.parseDouble(anInput);
                expression.addLast(anInput);
            } catch (Exception e) {
                switch (anInput) {
                    case "x":
                        expression.addLast(anInput);
                        break;
                    case "(":
                        operators.push(anInput);
                        break;
                    case ")":
                        String symbol = operators.pop();
                        while (!symbol.equals("(")) {
                            expression.addLast(symbol);
                            symbol = operators.pop();
                        }
                        break;
                    default:
                        while (!operators.isEmpty() && precendence.get(operators.peek()) >= precendence.get(anInput)) {
                            expression.addLast(operators.pop());
                        }
                        operators.push(anInput);
                        break;
                }
            }
        }
        while (!operators.isEmpty()) {
            expression.addLast(operators.pop());
        }

        while (expression.size() > 0) {
            System.out.print(expression.pop()+" ");
        }
    }
}
