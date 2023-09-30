package SetsAndMapsLab;

import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, Double> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            double sum = 0;
            long count = 0;
            for (double grade : grades) {
                sum += grade;
                count++;
            }
            double avg = sum / count;
            students.put(name, avg);
        }

        for (Map.Entry<String, Double> student : students.entrySet()) {
            System.out.printf("%s is graduated with %s%n", student.getKey(), student.getValue());
        }
    }
}
