package HappyFamilyTest;


import Homework9.Family;
import Homework9.Human;
import Homework9.Pet;
import Homework9.pets.Dog;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static Homework9.enums.DayOfWeek.FRIDAY;
import static Homework9.enums.DayOfWeek.MONDAY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FamilyTest {
    Human mother = new Human("Jessica", "Smith", 1910);
    Human father = new Human("John", "Smith", 1900);
    Family happyFamily = new Family(mother, father);
    Pet pet = new Dog("Bobik", 11, 56, Set.of("barking", "eating", "sleeping"));
    Human anderson = new Human(
            "Anderson",
            "Gutenberg",
            198,
            100,
            happyFamily,
            Map.of(MONDAY, "do magic", FRIDAY, "buy a coffee"));

    List<Human> addChildToFamily() {
        happyFamily.addChild(anderson);
        return  happyFamily.getChildren();
    }

    @Test
    void givenCountFamilyReturnSuccess() {
        addChildToFamily();
        assertEquals(3, happyFamily.countFamily());
    }

    @Test
    void givenDeleteChildByIndexWhenDeletedThenReturnSuccess() {
        addChildToFamily();
        happyFamily.deleteChildByIndex(0);
        assertEquals(0, this.happyFamily.getChildren().size());
    }

    @Test
    void givenDeleteChildByIndexWhenIndexIsWrong() {
        addChildToFamily();
        happyFamily.deleteChildByIndex(3);
        assertEquals(1, this.happyFamily.getChildren().size());
    }

    @Test
    void givenDeleteChildByHumanThenReturnSuccess() {
        addChildToFamily();
        happyFamily.deleteChildByHuman(this.anderson);
        assertEquals(0, this.happyFamily.getChildren().size());
    }

    @Test
    void givenDeleteChildByHumanWhenWrongReference() {
        addChildToFamily();

        Human anderson = new Human(
                "Anderson",
                "Gutenberg",
                198,
                100,
                happyFamily,
                Map.of(MONDAY, "do magic", FRIDAY, "buy a coffee"));
        happyFamily.deleteChildByHuman(anderson);
        assertEquals(0, this.happyFamily.getChildren().size());
    }

    @Test
    void addMotherAndFatherWhenNotEqualsThenReturnSuccess() {
        Human mother = new Human("Jennifer", "Lopez", 1968);
        Human father = new Human("Tom", "Cruise", 1962);
        Family anotherFamily = new Family(mother, father);
        assertNotEquals(anotherFamily, happyFamily);
    }

    @Test
    void addTheSameMotherAndFatherWhenEqualsThenReturnSuccess() {
        Human mother = new Human("Jessica", "Smith", 1910);
        Human father = new Human("John", "Smith", 1900);
        Family anotherFamily = new Family(mother, father);
        assertEquals(happyFamily, anotherFamily);
    }

    @Test
    void createFamilyWithTheSameChildWhenEqualsReturnSuccess() {
        addChildToFamily();
        Human mother = new Human("Jessica", "Smith", 1910);
        Human father = new Human("John", "Smith", 1900);
        Family anotherFamily = new Family(mother, father);

        Human anderson = new Human(
                "Anderson",
                "Gutenberg",
                198,
                100,
                happyFamily,
                Map.of(MONDAY, "do magic", FRIDAY, "buy a coffee"));

        anotherFamily.addChild(anderson);
        assertEquals(happyFamily, anotherFamily);
    }

    @Test
    void createFamilyWithAnotherChildWhenNotEqualsReturnSuccess() {
        addChildToFamily();
        Human mother = new Human("John", "Smith", 1977);
        Human father = new Human("Jessica", "Smith", 1973);
        Family anotherFamily = new Family(mother, father);

        Human fredrich = new Human(
                "Anderson",
                "Gutenberg",
                198,
                100,
                anotherFamily,
                Map.of(MONDAY, "do magic", FRIDAY, "buy a coffee"));

        anotherFamily.addChild(fredrich);
        assertNotEquals(happyFamily, anotherFamily);
    }
}
