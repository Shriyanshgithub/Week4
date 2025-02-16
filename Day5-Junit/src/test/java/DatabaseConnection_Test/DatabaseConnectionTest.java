package DatabaseConnection_Test;
import static org.junit.jupiter.api.Assertions.*;
import org.capgemini.Problem_5.DatabaseConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

//class DataBaseConnectionTest
public class DatabaseConnectionTest {

    private DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }

    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
    }

    @Test
    void testConnectionEstablished() {
        assertTrue(dbConnection.isConnected());
    }

    @Test
    void testConnectionClosedAfterTest() {
        assertTrue(dbConnection.isConnected()); // Still connected during the test
    }
}

