package ListExercise;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> resultList = new ArrayList<>();
        
        int firstElement = 0;
        int secondElement = 0;

        int length = Integer.min(firstList.size(), secondList.size());

        if (length == secondList.size()) {
            for (int i = 0; i < length; i++) {
                resultList.add(firstList.get(i));
                resultList.add(secondList.get(length - i - 1));
            }
            
            firstElement = firstList.get(firstList.size() - 2);
            secondElement = firstList.get((firstList.size() - 1));
        } else {
            for (int i = 0; i < length; i++) {
                resultList.add(firstList.get(i));
                resultList.add(secondList.get(secondList.size() - i - 1));
            }
            firstElement = secondList.get(0);
            secondElement = secondList.get(1);
        }

        int start = firstElement;
        int end = secondElement;
        if (firstElement > secondElement) {
            start = secondElement;
            end = firstElement;
        }

        List<Integer> sortedNums = new ArrayList<>();
        for (Integer i : resultList) {
            if (i > start && i < end) {
                sortedNums.add(i);
            }
        }
        Collections.sort(sortedNums);

        for (Integer num : sortedNums) {
            System.out.print(num + " ");
        }

    }
}
