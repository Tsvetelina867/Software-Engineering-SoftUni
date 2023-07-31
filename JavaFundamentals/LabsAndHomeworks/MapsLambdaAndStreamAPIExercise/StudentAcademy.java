package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Double> averageStudentMap = new LinkedHashMap<>();
        LinkedHashMap<String, List<Double>> gradesStudentMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!gradesStudentMap.containsKey(name)) {
                gradesStudentMap.put(name, new ArrayList<>());
            }
            gradesStudentMap.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : gradesStudentMap.entrySet()) {
            String key = entry.getKey();
            List<Double> values = entry.getValue();

            double sum = 0.0;
            for (Double value : values) {
                sum += value;
            }

            double average = sum / values.size();
            if (average >= 4.5) {
                System.out.printf("%s -> %.2f%n", key, average);
            }
        }
    }
}
