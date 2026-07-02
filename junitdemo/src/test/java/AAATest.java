import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AAATest {

    private int num;

    @Before
    public void setUp() {
        num = 5;
        System.out.println("Setup");
    }

    @Test
    public void testAddition() {

        // Arrange
        int a = num;
        int b = 3;

        // Act
        int result = a + b;

        // Assert
        assertEquals(8, result);
    }

    @After
    public void tearDown() {
        System.out.println("Teardown");
    }
}