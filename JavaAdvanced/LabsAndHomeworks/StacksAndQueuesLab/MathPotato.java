package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] kids = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        PriorityQueue<String> queue = new PriorityQueue<>();
        for (String kid : kids) {
            queue.offer(kid);
        }

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle ++;
        }
        System.out.println("Last is " + queue.peek());
        }

    public static boolean isPrime (int cycle) {

        int count = 0;

        for (int i = 1; i <= cycle; i++) {

            if (cycle % i == 0 ) {
                count ++;
            }
        }

        if (count > 2 || count == 1) {
            return false;
        }
        return true;
    }
    }
