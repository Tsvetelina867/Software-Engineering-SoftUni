package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] kids = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String kid : kids) {
            queue.offer(kid);
        }

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String removedKid = queue.poll();
                queue.offer(removedKid);
            }

            String removedKid = queue.poll();
            System.out.println("Removed " + removedKid);
        }
        String lastChild = queue.poll();
        System.out.println("Last is " + lastChild);
    }

}
