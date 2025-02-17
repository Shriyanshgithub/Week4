package org.capgemini.TODO_Task;

import java.lang.reflect.Method;

public class TodoProcessor {
    public static void main(String[] args) {
        // Get the Class object for PendingFeatures
        Class<PendingFeatures> cls = PendingFeatures.class;

        // Iterate through all declared methods
        for (Method method : cls.getDeclaredMethods()) {
            // Check if the method is annotated with @Todo
            if (method.isAnnotationPresent(Todo.class)) {
                // Retrieve the @Todo annotation
                Todo todo = method.getAnnotation(Todo.class);

                // Print details about the pending task
                System.out.println("Method: " + method.getName());
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("-------------------------");
            }
        }
    }
}
 class PendingFeatures {

    // Pending task: Implement user login feature with high priority.
    @Todo(task = "Implement user login", assignedTo = "Alice", priority = "HIGH")
    public void userLoginFeature() {
        // Pending implementation...
    }

    // Pending task: Add password reset functionality (default priority).
    @Todo(task = "Add password reset", assignedTo = "Bob")
    public void passwordResetFeature() {
        // Pending implementation...
    }

    // A method without a pending task annotation.
    public void regularMethod() {
        // Regular method code...
    }
}

