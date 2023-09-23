package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();
        String line = scanner.nextLine();

        while (!line.equals("print")) {
            if (line.equals("cancel")) {
                if (!queue.isEmpty()) {
                    System.out.println("Canceled " + queue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                queue.offer(line);
            }
            line = scanner.nextLine();
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
