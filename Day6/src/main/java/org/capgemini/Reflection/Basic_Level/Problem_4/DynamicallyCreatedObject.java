package org.capgemini.Reflection.Basic_Level.Problem_4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DynamicallyCreatedObject {
    public static void main(String[] args)  {

        try {
            // Load the Student class dynamically
            Class<?> studentClass = Class.forName("Student");

            // Get the default constructor
            Constructor<?> constructor = studentClass.getDeclaredConstructor();

            // Create an instance without using "new"
            Object studentObject = constructor.newInstance();

            // Print the instance to confirm object creation
            System.out.println("Student object created: " + studentObject);

        } catch (Exception e) {
            System.err.println("Error creating object: " + e.getMessage());
        }
    }

    }

class Student{
    private String name;

    public Student() {
        this.name = "Default Student";
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "'}";
    }
}