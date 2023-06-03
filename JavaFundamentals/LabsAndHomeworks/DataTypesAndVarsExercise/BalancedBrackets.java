package DataTypesAndVars;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int openBracketsCount = 0;
        boolean isBalanced = true;

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            if (input.equals("(")) {
                if (openBracketsCount > 0) {
                    isBalanced = false;
                    break;
                }
                openBracketsCount++;
            } else if (input.equals(")")) {
                if (openBracketsCount == 0) {
                    isBalanced = false;
                    break;
                }
                openBracketsCount--;
            }
        }
        if (openBracketsCount != 0) {
            isBalanced = false;
        }

        if (isBalanced) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
