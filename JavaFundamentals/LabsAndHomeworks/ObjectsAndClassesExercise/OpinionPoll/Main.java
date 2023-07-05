package ObjectsAndClassesExercise.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] inputTokens = input.split(" ");
            String name = inputTokens[0];
            int age = Integer.parseInt(inputTokens[1]);
            Person person = new Person(name, age);
            people.add(person);
        }
        for (Person person : people) {
            if (person.getAge() > 30) {
                System.out.printf("%s - %d%n", person.getName(), person.getAge());
            }
        }

    }
}
