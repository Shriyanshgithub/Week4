package org.capgemini.AnnotationMarkImportantMethods;

import java.lang.reflect.Method;

public class CreateMarkedAnnotation {
    public static void main(String[] args) {
        // Create an instance of ListOfImortantMessage
        ListOfImortantMessage list = new ListOfImortantMessage();
        // Get the Class object for the instance
        Class<?> cl = list.getClass();

        // Retrieve all declared methods of the class
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            m.setAccessible(true); // Allow access to private methods, if any

            // Check if the method is annotated with @ImportantMethod
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                // Get the @ImportantMethod annotation
                ImportantMethod importantMethod = m.getAnnotation(ImportantMethod.class);
                // Print the importance level and method name
                System.out.println(importantMethod.level());
                System.out.println(m.getName());
            }
        }
    }
}

// Class containing methods marked as important
class ListOfImortantMessage {
    @ImportantMethod(level = "LOW")
    void importantMessage() {
        System.out.println("This message is important");
    }

    @ImportantMethod(level = "MEDIUM")
    void usefullMessage() {
        System.out.println("This message is useful");
    }
}
