package ListLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = numbers.size();

        for (int i = 0; i < n / 2; i++) {
            int firstNum = numbers.get(i);
            int secondNum = numbers.get(numbers.size() - 1);
            numbers.set(i, firstNum + secondNum);
            numbers.remove(Integer.valueOf(secondNum));
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
