package SetsAndMapsLab;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, ArrayList<Double>> grades = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            grades.putIfAbsent(name, new ArrayList<>());
            grades.get(name).add(grade);

        }

        for (Map.Entry<String, ArrayList<Double>> student : grades.entrySet()) {
            System.out.print(student.getKey() + " -> ");
            student.getValue().forEach(grade -> {
                System.out.printf("%.2f ", grade);
            });

            double sum = 0;
            for (Double v : student.getValue()) {
                sum += v;
            }

            double avg = sum / student.getValue().size();
            System.out.printf("(avg: %.2f)%n", avg);

        }
    }
}
