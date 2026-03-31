import org.junit.Test;

public class ExceptionTest {

    @Test(expected = ArithmeticException.class)
    public void testException() {
        int x = 10 / 0;
    }
}
