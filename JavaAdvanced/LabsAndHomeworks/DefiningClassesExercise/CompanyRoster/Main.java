package DefiningClassesExercise.CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee emp;
            if (tokens.length == 4) {
                emp = new Employee(name, salary, position, department);

            } else if (tokens.length == 5) {
                if (tokens[4].matches("\\d+")) {
                    int age = Integer.parseInt(tokens[4]);
                    emp = new Employee(name, salary, position, department, age);
                } else {
                    String email = tokens[4];
                    emp = new Employee(name, salary, position, department, email);
                }
            } else {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                    emp = new Employee(name, salary, position, department, email, age);
            }
            employees.add(emp);
        }

        Map.Entry<String, List<Employee>> highestPayingDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet()
                .stream().min((e1, e2) -> {
                    double averageE1 = e1.getValue().stream()
                            .mapToDouble(Employee::getSalary)
                            .average()
                            .getAsDouble();
                    double averageE2 = e2.getValue().stream()
                            .mapToDouble(Employee::getSalary)
                            .average()
                            .getAsDouble();

                    return Double.compare(averageE2, averageE1);
                }).orElse(null);
        assert highestPayingDepartment != null;
        System.out.println("Highest Average Salary: " + highestPayingDepartment.getKey());
        highestPayingDepartment.getValue()
                .stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
