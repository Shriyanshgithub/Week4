package org.capgemini.ExceptionPropagationinMethods;

public class ExceptionPropagationInMethods {
    public static void main(String[] args) {
        try {
            // Calling method2, which will propagate exceptions from method1
            method2();
        } catch (ArithmeticException e) {
            // Handling the exception in the main method
            System.out.println("Handled exception in main");
        }
    }

    public static void method2() {
        // Calling method1, which will throw an ArithmeticException
        method1();
    }

    public static void method1() {
        // Throwing an exception to demonstrate exception propagation
        throw new ArithmeticException("Division by zero");
    }
}
