package org.capgemini.Logging_Method_Execution_Time;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LogTimeExecutionExample {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        // Create an instance of PerformanceTest
        PerformanceTest performanceTest = new PerformanceTest();
        Class<?> cl = performanceTest.getClass();

        // Get all declared methods of PerformanceTest
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true); // Allow access to private methods
            // Check if the method is annotated with @LogExecutionTime
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime(); // Start timing
                method.invoke(performanceTest);      // Invoke the method
                long endTime = System.nanoTime();    // End timing

                // Print the method name and its execution time
                System.out.println("The method: " + method.getName() +
                        " has execution time: " + (endTime - startTime) + " ns");
            }
        }
    }
}

class PerformanceTest {
    @LogExecutionTime
    void fastLoggingTime() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        System.out.println("The sum is " + sum);
    }

    @LogExecutionTime
    void slowLoggingTime() {
        try {
            Thread.sleep(100); // Simulate a slow operation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
