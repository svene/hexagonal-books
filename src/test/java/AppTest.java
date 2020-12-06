import net.jqwik.api.Example;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test public void greeting_junit() {
        App classUnderTest = new App();
        assertEquals("Hello world.", classUnderTest.getGreeting());
    }
    @Test public void greeting_assertj() {
        App classUnderTest = new App();
        assertThat(classUnderTest.getGreeting()).isEqualTo("Hello world.");
    }

    @Example
    public void greeting_jqwik_example() {
        App classUnderTest = new App();
        assertThat(classUnderTest.getGreeting()).isEqualTo("Hello world.");
    }

}
