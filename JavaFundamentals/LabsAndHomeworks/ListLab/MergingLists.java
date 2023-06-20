package ListLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();

        int endFirst = firstList.size();
        int endSecond = secondList.size();

        if (firstList.size() <= secondList.size()) {
            for (int i = 0; i < firstList.size(); i++) {
                resultList.add(firstList.get(i));
                resultList.add(secondList.get(i));
            }
            for (int i = endFirst; i < secondList.size(); i++) {
                resultList.add(secondList.get(i));
            }
        } else {
            for (int i = 0; i < secondList.size(); i++) {
                resultList.add(firstList.get(i));
                resultList.add(secondList.get(i));
            }
            for (int i = endSecond; i < firstList.size(); i++) {
                resultList.add(firstList.get(i));
            }
        }
        for (Integer integer : resultList) {
            System.out.print(integer + " ");
        }

    }
}
