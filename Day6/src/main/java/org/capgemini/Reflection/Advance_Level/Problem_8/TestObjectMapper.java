package org.capgemini.Reflection.Advance_Level.Problem_8;

import java.util.HashMap;
import java.util.Map;

class Person {
    private String name;
    private int age;
    private boolean isEmployed;

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", isEmployed=" + isEmployed + "}";
    }
}

public class TestObjectMapper {
    public static void main(String[] args) {
        Map<String, Object> personData = new HashMap<>();
        personData.put("name", "John Doe");
        personData.put("age", 30);
        personData.put("isEmployed", true);

        // Convert Map to Person object
        Person person = ObjectMapper.toObject(Person.class, personData);

        // Print the created object
        System.out.println(person);
    }
}

