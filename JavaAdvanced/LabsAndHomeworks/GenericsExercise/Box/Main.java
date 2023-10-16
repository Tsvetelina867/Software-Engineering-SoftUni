package GenericsExercise.Box;

import GenericsExercise.Box.Box;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Double> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double line = Double.parseDouble(scanner.nextLine());
            list.add(line);
        }
        int count = 0;
        double elementToCheckWith = Double.parseDouble(scanner.nextLine());
        Box<Double> box = new Box<>(list, elementToCheckWith);

        for (Double item : list) {
            if (box.compare(item, elementToCheckWith)) {
                count++;
            }
        }
        System.out.println(count);

    }
}
