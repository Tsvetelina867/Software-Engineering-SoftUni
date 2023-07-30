package ObjectsAndClassesExercise.CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employee;
    private double avgSalary;

    Department(String name, List<Employee> employee) {
        this.name = name;
        this.employee = employee;
        this.avgSalary = employee.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public double getAvgSalary() {
        return avgSalary;
    }

    public String getName() {
        return name;
    }
}
