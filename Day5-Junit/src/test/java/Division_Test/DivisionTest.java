package Division_Test;

import static org.junit.jupiter.api.Assertions.*;
import org.capgemini.Problem_4.Division;
import org.junit.jupiter.api.Test;

public class DivisionTest {

    Division division = new Division();

    @Test
    void testDivide() {
        assertEquals(2, division.divide(10, 5));
        assertEquals(-3, division.divide(-9, 3));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> division.divide(10, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
