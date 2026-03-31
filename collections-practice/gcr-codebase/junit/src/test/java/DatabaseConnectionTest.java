import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class DatabaseConnectionTest {

    DatabaseConnection db;

    @Before
    void setup() {
        db = new DatabaseConnection();
        db.connect();
    }

    @After
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testConnection() {
        assertTrue(db.connected);
    }
}
