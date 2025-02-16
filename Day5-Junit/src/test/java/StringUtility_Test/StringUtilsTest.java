package StringUtility_Test;

import static org.junit.jupiter.api.Assertions.*;
import org.capgemini.Problem_2.StringUtils;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    StringUtils stringUtils = new StringUtils();

    @Test
    void testReverse() {
        assertEquals("olleh", stringUtils.reverse("hello"));
        assertEquals("12321", stringUtils.reverse("12321"));
        assertNull(stringUtils.reverse(null));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertTrue(stringUtils.isPalindrome("Racecar"));
        assertFalse(stringUtils.isPalindrome("hello"));
        assertFalse(stringUtils.isPalindrome(null));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
        assertEquals("WORLD", stringUtils.toUpperCase("World"));
        assertNull(stringUtils.toUpperCase(null));
    }
}

