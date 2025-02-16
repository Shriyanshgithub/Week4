package org.capgemini.Reflection.Advance_Level.Problem_12;

import java.lang.reflect.Method;

class SampleClass {
    public void fastMethod() {
        System.out.println("Executing fastMethod...");
    }

    public void slowMethod() {
        System.out.println("Executing slowMethod...");
        try {
            Thread.sleep(2000); // Simulating a slow operation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void mediumMethod() {
        System.out.println("Executing mediumMethod...");
        try {
            Thread.sleep(1000); // Simulating a medium-speed operation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class MethodExecutionTimer {
    public static void main(String[] args) {
        try {
            SampleClass obj = new SampleClass();
            Class<?> clazz = obj.getClass();

            // Get all declared methods of SampleClass
            Method[] methods = clazz.getDeclaredMethods();

            for (Method method : methods) {
                if (method.getParameterCount() == 0) { // Ensuring method has no parameters
                    System.out.println("\nInvoking method: " + method.getName());

                    long startTime = System.nanoTime(); // Start time
                    method.invoke(obj); // Invoke method dynamically
                    long endTime = System.nanoTime(); // End time

                    long executionTime = (endTime - startTime) / 1_000_000; // Convert to milliseconds
                    System.out.println("Execution time: " + executionTime + " ms");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

