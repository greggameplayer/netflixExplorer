import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class HelloWorldTest {
    @Test
    public void testHelloWorld() {
        assertNotEquals("Hello World!", "hello world!");
    }
}
