package org.capgemini.Map_Interface.Problem_5;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;

    // Constructor
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    // Override toString for easy output
    @Override
    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static void main(String[] args) {
        // Example list of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        // Group employees by department
        Map<String, List<Employee>> groupedByDepartment = groupByDepartment(employees);

        // Output the result
        groupedByDepartment.forEach((department, employeesInDept) ->
                System.out.println(department + ": " + employeesInDept)
        );
    }

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        // Use a map to group employees by their department
        Map<String, List<Employee>> result = new HashMap<>();

        for (Employee employee : employees) {
            // Get the department of the current employee
            String department = employee.getDepartment();

            // Add the employee to the corresponding department group
            result.computeIfAbsent(department, k -> new ArrayList<>()).add(employee);
        }

        return result;
    }
}
