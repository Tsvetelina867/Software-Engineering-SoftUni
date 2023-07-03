package ObjectsAndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    public static class Student {
        private String firstName;
        private String lastName;
        private int age;
        private String town;

        public int getAge() {
            return age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getTown() {
            return town;
        }

        public Student(String firstName, String lastName, int age, String town) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.town = town;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        List<Student> studentList = new ArrayList<>();

        while (!command.equals("end")) {
            String[] commandTokens = command.split(" ");
            String firstName = commandTokens[0];
            String lastName = commandTokens[1];
            int age = Integer.parseInt(commandTokens[2]);
            String town = commandTokens[3];
            Student student = new Student(firstName, lastName, age, town);
            studentList.add(student);

            command = scanner.nextLine();
        }
        String town = scanner.nextLine();

        for (Student student : studentList) {
            if (student.getTown().equals(town)) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }


    }
}
