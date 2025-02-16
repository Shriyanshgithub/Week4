package DateFormatter_Test;

import static org.junit.jupiter.api.Assertions.*;

import org.capgemini.Advance_Problem.Problem_4.DateFormatter;
import org.junit.jupiter.api.Test;

class DateFormatterTest {

    @Test
    void testValidDateFormat() {
        assertEquals("15-07-2023", DateFormatter.formatDate("2023-07-15"));
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"));
        assertEquals("31-12-1999", DateFormatter.formatDate("1999-12-31"));
    }

    @Test
    void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("15-07-2023")); // Wrong format
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("07/15/2023")); // Wrong delimiter
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("abcd-ef-gh")); // Non-numeric
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("")); // Empty input
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate(null)); // Null input
    }
}

