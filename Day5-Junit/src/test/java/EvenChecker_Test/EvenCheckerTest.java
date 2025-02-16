package EvenChecker_Test;

import static org.junit.jupiter.api.Assertions.*;
import org.capgemini.Problem_6.EvenChecker;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenCheckerTest {

    EvenChecker evenChecker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10}) // Testing even numbers
    void testIsEven_TrueCases(int number) {
        assertTrue(evenChecker.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9}) // Testing odd numbers
    void testIsEven_FalseCases(int number) {
        assertFalse(evenChecker.isEven(number));
    }
}

