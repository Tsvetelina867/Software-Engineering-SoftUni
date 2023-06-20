package ListExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("3:1")) {
            String[] commandTokens = command.split(" ");
            command = commandTokens[0];

            if (command.equals("merge")) {
                int startIndex = Integer.parseInt(commandTokens[1]);
                int endIndex = Integer.parseInt(commandTokens[2]);
                list = mergeElements(list, startIndex, endIndex);
            } else if (command.equals("divide")) {
                int index = Integer.parseInt(commandTokens[1]);
                int partitions = Integer.parseInt(commandTokens[2]);
                list = divideElements(list, index, partitions);
            }
            command = scanner.nextLine();
        }

        System.out.println(String.join(" ", list));
    }

    public static List<String> mergeElements(List<String> list, int start, int end) {
        String output = "";
        if (start < 0 || start > list.size()) {
            start = 0;
        }
        if (end > list.size() - 1) {
            end = list.size() - 1;
        }
        for (int i = start; i <= end; i++) {
            output += list.get(i);

        }
        list.set(start, output);
        list.set(start, output.toString());
        int elementsToRemove = end - start;
        for (int i = 0; i < elementsToRemove; i++) {
            list.remove(start + 1);
        }
        return list;
    }

    public static List<String> divideElements(List<String> input, int index, int partitions) {
        List<String> result = new ArrayList<>();
        int currentIndex = 0;
        int currentPartition = 0;

        for (int i = 0; i < input.size(); i++) {
            if (i == index) {
                String currentString = input.get(i);
                int partitionLength = currentString.length() / partitions;
                int remainingLength = currentString.length() % partitions;

                for (int j = 0; j < partitions; j++) {
                    int substringLength = partitionLength;
                    if (j == partitions - 1) {
                        substringLength += remainingLength;
                    }
                    result.add(currentString.substring(currentPartition, currentPartition + substringLength));
                    currentPartition += substringLength;
                }
            } else {
                result.add(input.get(i));
            }
        }

        return result;
    }
}

