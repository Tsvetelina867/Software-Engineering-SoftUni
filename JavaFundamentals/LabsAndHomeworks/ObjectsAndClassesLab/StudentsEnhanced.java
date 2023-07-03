package ObjectsAndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsEnhanced {
    public static class Student {
        private String firstName;
        private String lastName;
        private int age;
        private String town;

        public void setAge(int age) {
            this.age = age;
        }

        public void setTown(String town) {
            this.town = town;
        }

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
        List<StudentsEnhanced.Student> studentsList = new ArrayList<>();

        while (!command.equals("end")) {
            String[] commandTokens = command.split(" ");
            String firstName = commandTokens[0];
            String lastName = commandTokens[1];
            int age = Integer.parseInt(commandTokens[2]);
            String town = commandTokens[3];

            if (isStudentExisting(firstName, lastName, studentsList)) {
                int index = getExistingIndex(studentsList, firstName, lastName);
                studentsList.get(index).setAge(age);
                studentsList.get(index).setTown(town);
            } else {
                Student currentStudent = new Student(firstName, lastName, age, town);
                studentsList.add(currentStudent);
            }

            command = scanner.nextLine();
        }
        String town = scanner.nextLine();
        for (StudentsEnhanced.Student student : studentsList) {
            if (student.getTown().equals(town)) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }

    public static boolean isStudentExisting(String firstName, String lastName, List<Student> students) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    public static int getExistingIndex (List<Student> studentsList, String firstName, String lastName) {
        int index = -1;
        for (int i = 0; i < studentsList.size(); i++) {
            Student student = studentsList.get(i);
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                index = i;
            }
        }
        return index;
    }
}
