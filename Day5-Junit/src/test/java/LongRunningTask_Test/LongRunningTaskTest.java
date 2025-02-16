package LongRunningTask_Test;

import static org.junit.jupiter.api.Assertions.*;

import org.capgemini.Problem_7.LongRunningTask;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class LongRunningTaskTest {

    LongRunningTask task = new LongRunningTask();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Test will fail if it takes >2 sec
    void testLongRunningTask() {
        task.executeTask(); // This method takes 3 seconds, so the test should fail
    }
}

