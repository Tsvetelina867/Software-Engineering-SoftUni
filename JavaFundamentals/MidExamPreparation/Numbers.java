package MidExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numsArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> greaterNumsList = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < numsArr.length; i++) {
            sum += numsArr[i];
        }

        double average = sum * 1.0 / numsArr.length;

        for (int j : numsArr) {
            if (j > average) {
                greaterNumsList.add(j);
            }
        }
        Collections.sort(greaterNumsList);

        if (greaterNumsList.size() == 0) {
            System.out.println("No");
        } else if (greaterNumsList.size() < 6) {
            Collections.reverse(greaterNumsList);
            for (Integer num : greaterNumsList) {
                System.out.print(num + " ");
            }
        } else if (greaterNumsList.size() > 5) {
            Collections.reverse(greaterNumsList);
            List<Integer> topFiveNumsList = greaterNumsList.subList(0, 5);
            for (Integer integer : topFiveNumsList) {
                System.out.print(integer + " ");
            }
        }
    }
}
