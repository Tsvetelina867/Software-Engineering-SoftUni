package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, List<String>> coursesMap = new LinkedHashMap<>();

        while (!input.equals("end")) {
            String[] inputTokens = input.split(" : ");
            String courseName = inputTokens[0];
            String studentName = inputTokens[1];

            if (!coursesMap.containsKey(courseName)) {
                coursesMap.put(courseName, new ArrayList<>());
            }
            coursesMap.get(courseName).add(studentName);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : coursesMap.entrySet()) {
            System.out.printf("%s: %s%n", entry.getKey(), entry.getValue().size());
            List<String> values = entry.getValue();
            for (String value : values) {
                System.out.println("-- " + value);
            }
        }
    }
}
