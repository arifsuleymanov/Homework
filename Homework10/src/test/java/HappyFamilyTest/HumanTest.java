package HappyFamilyTest;

import Homework10.Human;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class HumanTest {
    private final Human human = new Human("John", "Smith", "13/08/1910");

    public HumanTest() throws ParseException {
    }

    @Test
    void whenTwoObjectEqualsReturnSuccess() throws ParseException {
        Human anotherHuman = new Human("John", "Smith", "13/08/1910");
        assertEquals(human, anotherHuman);
    }

    @Test
    void whenTwoObjectNotEqualsReturnSuccess() throws ParseException {
        Human anotherHuman = new Human("Jony", "Smith", "13/08/1910");
        assertNotEquals(human, anotherHuman);
    }
}
