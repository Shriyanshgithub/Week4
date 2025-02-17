package org.capgemini.Reflection.Basic_Level.Problem_2;

import java.lang.reflect.Field;

public class GetPrivateAccess {
    public static void main(String[] args) {
        try {
            Person person = new Person();
            Class<?> cl = person.getClass();

            // Access private field "age"
            Field field = cl.getDeclaredField("age");
            field.setAccessible(true); // Bypass access control

            // Modify the private field value
            field.set(person, 23);

            // Retrieve and print the modified value
            int modifiedAge = (int) field.get(person);
            System.out.println("Age after reflection: " + modifiedAge);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.err.println("Reflection Error: " + e.getMessage());
        }
    }
}

// Person class with a private field
class Person {
    private int age;
}

