package HappyFamilyTest;

import homework6.Human;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class HumanTest {
    private final Human human = new Human("John", "Smith", 1900);

    @Test
    void whenTwoObjectEqualsReturnSuccess() {
        Human anotherHuman = new Human("John", "Smith", 1900);
        assertEquals(human, anotherHuman);
    }

    @Test
    void whenTwoObjectNotEqualsReturnSuccess() {
        Human anotherHuman = new Human("Jony", "Smith", 1900);
        assertNotEquals(human, anotherHuman);
    }
}
