package DataTypesAndVars;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        int courses = 0;

        if (people <= capacity) {
            courses = 1;
        } else {
            courses = people / capacity;
            if (capacity * courses < people) {
                courses++;
            }
        }
        System.out.println(courses);
    }
}
