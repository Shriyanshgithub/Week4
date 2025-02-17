package org.capgemini.Reflection.Advance_Level.Problem_9;

class Person {
    private String name;
    private int age;
    private boolean isEmployed;

    public Person(String name, int age, boolean isEmployed) {
        this.name = name;
        this.age = age;
        this.isEmployed = isEmployed;
    }
}

public class TestJsonConverter {
    public static void main(String[] args) {
        Person person = new Person("John Doe", 30, true);

        // Convert object to JSON-like string
        String json = JsonConverter.toJson(person);

        // Print JSON representation
        System.out.println(json);
    }
}
