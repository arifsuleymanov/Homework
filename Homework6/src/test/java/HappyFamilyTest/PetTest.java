package HappyFamilyTest;

import homework6.Pet;
import homework6.enums.Species;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PetTest {

    private final Pet pet = new Pet(Species.DOG, "Bobik", 11, 56, new String[]{"barking", "eating", "sleeping"});

    @Test
    void whenTwoObjectEqualsReturnSuccess() {
        Pet anotherPet = new Pet(Species.DOG, "Bobik", 11, 56, new String[]{"barking", "eating", "sleeping"});
        assertEquals(anotherPet, pet);
    }

    @Test
    void whenTwoObjectNotEqualsReturnSuccess() {
        Pet anotherPet = new Pet(Species.CAT, "Wizik", 12, 78, new String[]{"flying", "eating", "sleeping"});
        assertNotEquals(anotherPet, pet);
    }

}
