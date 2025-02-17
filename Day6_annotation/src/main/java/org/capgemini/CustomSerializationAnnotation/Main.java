package org.capgemini.CustomSerializationAnnotation;

public class Main {
    public static void main(String[] args) {
        User user = new User("john_doe", "john@example.com", 30);
        try {
            String jsonString = JsonSerializer.serialize(user);
            System.out.println(jsonString);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}



 class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_email")
    private String email;

    private int age; // This field won't be serialized as it lacks the annotation

    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }

    // Getters and setters (omitted for brevity)
}

