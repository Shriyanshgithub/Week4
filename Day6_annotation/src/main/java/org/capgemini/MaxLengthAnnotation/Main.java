package org.capgemini.MaxLengthAnnotation;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("JohnDoe"); // Valid username
            System.out.println("User1 created with username: " + user1.getUsername());

            User user2 = new User("ThisUsernameIsTooLong"); // Invalid username
            System.out.println("User2 created with username: " + user2.getUsername());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}

 class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        this.username = username;
        validateMaxLength();
    }

    private void validateMaxLength() {
        try {
            // Access the 'username' field
            var field = this.getClass().getDeclaredField("username");
            // Check if the 'MaxLength' annotation is present
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                // Validate the length of the 'username'
                if (username != null && username.length() > maxLength.value()) {
                    throw new IllegalArgumentException("Username exceeds maximum length of " + maxLength.value());
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    // Getter and setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        validateMaxLength();
    }
}


