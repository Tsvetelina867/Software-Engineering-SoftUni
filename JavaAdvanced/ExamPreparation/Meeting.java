package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> menStack = new ArrayDeque<>();
        Deque<Integer> womenQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(menStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(womenQueue::offer);
        int equals = 0;

        while (!menStack.isEmpty() && !womenQueue.isEmpty()) {
            int man = menStack.getFirst();
            int woman = womenQueue.getFirst();
            if (man < 1) {
                menStack.pop();
                continue;
            }
            if (woman < 1) {
                womenQueue.poll();
                continue;
            }
            if (man % 25 == 0) {
                menStack.pop();
                menStack.pop();
                continue;
            }
            if (woman % 25 == 0) {
                womenQueue.poll();
                womenQueue.poll();
                continue;
            }
            if (man == woman) {
                equals++;
                menStack.pop();
                womenQueue.poll();
            } else {
                womenQueue.poll();
                man -= 2;
                menStack.pop();
                menStack.push(man);
            }
        }

        System.out.println("Matches: " + equals);
        if (menStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.println("Males left: " + String.join(", ", menStack.stream()
                    .map(String::valueOf).toArray(String[]::new)));
        }
        if (womenQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.println("Females left: " + String.join(", ", womenQueue.stream()
                    .map(String::valueOf).toArray(String[]::new)));
        }

    }
}
