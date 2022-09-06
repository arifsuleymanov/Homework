package HappyFamilyTest;

import Homework10.Pet;
import Homework10.pets.DomesticCat;
import Homework10.pets.Fish;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PetTest {

    private final Pet pet = new DomesticCat("Bobik", 11, 56, Set.of("barking", "eating",
            "sleeping"));

    @Test
    void whenTwoObjectEqualsReturnSuccess() {
        Pet anotherPet = new DomesticCat("Bobik", 11, 56, Set.of("barking", "eating", "sleeping"));
        assertEquals(anotherPet, pet);
    }

    @Test
    void whenTwoObjectNotEqualsReturnSuccess() {
        Pet anotherPet = new Fish("Wizik", 12, 78, Set.of("flying", "eating", "sleeping"));
        assertNotEquals(anotherPet, pet);
    }

}
