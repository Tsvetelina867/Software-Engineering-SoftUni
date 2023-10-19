package IteratorsAndComparatorsExercise.ListyIterator;

import IteratorsAndComparatorsExercise.ListyIterator.ListyIterator;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] parts = Arrays.stream(scanner.nextLine().split("\\s+")).skip(1).toArray(String[]::new);
        ListyIterator list = new ListyIterator(parts);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            if (input.equals("Move")) {
                System.out.println(list.move());
            } else if (input.equals("HasNext")) {
                System.out.println(list.hasNext());
            } else if (input.equals("Print")) {
                try {
                    list.print();
                } catch (IllegalStateException e){
                    System.out.println(e.getMessage());
                }
            } else if (input.equals("PrintAll")) {
                list.forEach( e -> System.out.print(e + " "));
                System.out.println();
            }

            input = scanner.nextLine();
        }
    }
}
