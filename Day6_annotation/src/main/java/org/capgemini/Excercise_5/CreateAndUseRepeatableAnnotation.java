package org.capgemini.Excercise_5;

import java.lang.reflect.Method;

// Demonstrates using repeatable @BugReport annotations via reflection
public class CreateAndUseRepeatableAnnotation {
    public static void main(String[] args) throws ClassNotFoundException {
        // Load the TaskManager class
        Class<?> cl = Class.forName("org.capgemini.Excercise_5.TaskManager");
        // Get all declared methods
        Method[] methods = cl.getDeclaredMethods();

        // Iterate over each method
        for (Method m : methods) {
            m.setAccessible(true); // Allow access to non-public methods

            // Check if any BugReport annotation is present
            if (m.isAnnotationPresent(BugReport.class)) {
                BugReport br = m.getAnnotation(BugReport.class);
                System.out.println("The method is : " + m.getName());
            }

            // Retrieve all BugReport annotations on the method
            BugReport[] bugReports = m.getAnnotationsByType(BugReport.class);
            for (BugReport b : bugReports) {
                System.out.println("The description is : " + b.description());
            }
        }
    }
}

// TaskManager with repeatable @BugReport annotations on its method
class TaskManager {
    @BugReport(description = "Null Pointer")
    @BugReport(description = "Arithemetic exception")
    void bugFix() {
        System.out.println("The bug is permanent");
    }
}

