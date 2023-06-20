package ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessons = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("course start")) {
            String[] commandTokens = command.split(":");
            String action = commandTokens[0];
            String lessonTitle = commandTokens[1];

            switch (action) {
                case "Add":
                    addLesson(lessons, lessonTitle);
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandTokens[2]);
                    insertLesson(lessons, lessonTitle, index);
                    break;
                case "Remove":
                    removeLesson(lessons, lessonTitle);
                    break;
                case "Swap":
                    String lessonToSwapWith = commandTokens[2];
                    swapLessons(lessons, lessonTitle, lessonToSwapWith);
                    break;
                case "Exercise":
                    addExercise(lessons, lessonTitle);
                    break;
            }

            command = scanner.nextLine();
        }

        printCourseSchedule(lessons);
    }

    private static void addLesson(List<String> lessons, String lessonTitle) {
        if (!lessons.contains(lessonTitle)) {
            lessons.add(lessonTitle);
        }
    }

    private static void insertLesson(List<String> lessons, String lessonTitle, int index) {
        if (!lessons.contains(lessonTitle)) {
            if (index >= 0 && index < lessons.size()) {
                lessons.add(index, lessonTitle);
            }
        }
    }

    private static void removeLesson(List<String> lessons, String lessonTitle) {
        int lessonIndex = lessons.indexOf(lessonTitle);
        if (lessonIndex != -1) {
            lessons.remove(lessonIndex);
            if (lessonIndex < lessons.size() && lessons.get(lessonIndex).endsWith("-Exercise")) {
                lessons.remove(lessonIndex);
            }
        }
    }

    private static void swapLessons(List<String> lessons, String lessonTitle1, String lessonTitle2) {
        if (lessons.contains(lessonTitle1) && lessons.contains(lessonTitle2)) {
            int index1 = lessons.indexOf(lessonTitle1);
            int index2 = lessons.indexOf(lessonTitle2);

            lessons.set(index1, lessonTitle2);
            lessons.set(index2, lessonTitle1);

            String exercise1 = lessonTitle1 + "-Exercise";
            String exercise2 = lessonTitle2 + "-Exercise";

            if (lessons.contains(exercise1)) {
                int exerciseIndex1 = lessons.indexOf(exercise1);
                lessons.remove(exercise1);
                lessons.add(index2 + 1, exercise1);
            }

            if (lessons.contains(exercise2)) {
                int exerciseIndex2 = lessons.indexOf(exercise2);
                lessons.remove(exercise2);
                lessons.add(index1 + 1, exercise2);
            }
        }
    }

    private static void addExercise(List<String> lessons, String lessonTitle) {
        String exerciseName = lessonTitle + "-Exercise";

        if (lessons.contains(lessonTitle)) {
            int lessonIndex = lessons.indexOf(lessonTitle);
            if (lessonIndex == lessons.size() - 1 || !lessons.get(lessonIndex + 1).equals(exerciseName)) {
                lessons.add(lessonIndex + 1, exerciseName);
            }
        } else {
            lessons.add(lessonTitle);
            lessons.add(exerciseName);
        }
    }

    private static void printCourseSchedule(List<String> lessons) {
        for (int i = 0; i < lessons.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, lessons.get(i));
        }
    }
}
