package PasswordValidator_Test;

import static org.junit.jupiter.api.Assertions.*;

import org.capgemini.Advance_Problem.Problem_2.PasswordValidator;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {

    @Test
    void testValidPasswords() {
        assertTrue(PasswordValidator.isValidPassword("StrongPass1"), "Valid password should pass");
        assertTrue(PasswordValidator.isValidPassword("HelloWorld9"), "Valid password should pass");
        assertTrue(PasswordValidator.isValidPassword("JavaRocks8"), "Valid password should pass");
    }

    @Test
    void testInvalidPasswords() {
        assertFalse(PasswordValidator.isValidPassword("short1"), "Too short");
        assertFalse(PasswordValidator.isValidPassword("alllowercase9"), "No uppercase letter");
        assertFalse(PasswordValidator.isValidPassword("NOLOWERCASE1"), "No lowercase letter");
        assertFalse(PasswordValidator.isValidPassword("NoDigitsHere"), "No digit");
        assertFalse(PasswordValidator.isValidPassword(""), "Empty password should fail");
        assertFalse(PasswordValidator.isValidPassword(null), "Null password should fail");
    }
}

