/*
Serialization - Save and Retrieve an Object
📌 Problem Statement:
Design a Java program that allows a user to store a list of employees in a file using Object Serialization and later retrieve the data from the file.
Requirements:
Create an Employee class with fields: id, name, department, salary.
Serialize the list of employees into a file (ObjectOutputStream).
Deserialize and display the employees from the file (ObjectInputStream).
Handle ClassNotFoundException and IOException.
 */

package org.capgemini.Problem_4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Employee class must implement Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for Serializable classes
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Override toString() for easy display of employee data
    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Department=" + department + ", Salary=" + salary + "]";
    }
}

public class EmployeeSerialization {
    private static final String FILE_NAME = "\"C:/Users/HP/Desktop/Week4/Day3/src/main/resources/file2.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main menu
        while (true) {
            System.out.println("\n--- Employee Serialization Program ---");
            System.out.println("1. Add and Save Employees");
            System.out.println("2. Load and Display Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    saveEmployees();
                    break;
                case 2:
                    loadEmployees();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to add employees and serialize them
    private static void saveEmployees() {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter the number of employees to add: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for employee " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();

            // Add new Employee to the list
            employees.add(new Employee(id, name, department, salary));
        }

        // Serialize the employee list to a file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees have been saved to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error while saving employees: " + e.getMessage());
        }
    }

    // Method to deserialize and display employees
    private static void loadEmployees() {
        // Deserialize the employee list from the file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            List<Employee> employees = (List<Employee>) ois.readObject();
            System.out.println("\n--- Employee List ---");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } catch (IOException e) {
            System.err.println("Error while loading employees: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Employee class not found.");
        }
    }
}

