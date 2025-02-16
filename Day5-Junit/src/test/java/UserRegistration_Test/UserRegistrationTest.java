package UserRegistration_Test;

import static org.junit.jupiter.api.Assertions.*;

import org.capgemini.Advance_Problem.Problem_5.UserRegistration;
import org.junit.jupiter.api.Test;

 public class UserRegistrationTest {

    @Test
    void testValidUserRegistration() {
        assertEquals("User registered successfully!", UserRegistration.registerUser("JohnDoe", "johndoe@example.com", "Password1"));
        assertEquals("User registered successfully!", UserRegistration.registerUser("Alice", "alice123@mail.com", "SecurePass9"));
    }

    @Test
    void testInvalidUsernames() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("", "user@example.com", "Password1"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser(null, "user@example.com", "Password1"));
    }

    @Test
    void testInvalidEmails() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("User", "invalid-email", "Password1"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("User", "user@", "Password1"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("User", null, "Password1"));
    }

    @Test
    void testInvalidPasswords() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("User", "user@example.com", "short"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("User", "user@example.com", "nouppercase1"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("User", "user@example.com", "NOLOWERCASE1"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("User", "user@example.com", null));
    }
}

