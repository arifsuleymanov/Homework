package HappyFamilyTest;


import Homework10.Family;
import Homework10.Human;
import Homework10.Pet;
import Homework10.pets.Dog;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static Homework10.enums.DayOfWeek.FRIDAY;
import static Homework10.enums.DayOfWeek.MONDAY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FamilyTest {
    Human mother = new Human("Jessica", "Smith", "13/08/1910");
    Human father = new Human("John", "Smith", "13/08/1910");
    Family happyFamily = new Family(mother, father);
    Pet pet = new Dog("Bobik", 11, 56, Set.of("barking", "eating", "sleeping"));
    Human anderson = new Human(
            "Anderson",
            "Gutenberg",
            198,
            "13/08/1910",
            happyFamily,
            Map.of(MONDAY, "do magic", FRIDAY, "buy a coffee"));

    public FamilyTest() throws ParseException {
    }

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
    void givenDeleteChildByHumanWhenWrongReference() throws ParseException {
        addChildToFamily();

        Human anderson = new Human(
                "Anderson",
                "Gutenberg",
                198,
                "13/08/1910",
                happyFamily,
                Map.of(MONDAY, "do magic", FRIDAY, "buy a coffee"));
        happyFamily.deleteChildByHuman(anderson);
        assertEquals(0, this.happyFamily.getChildren().size());
    }

    @Test
    void addMotherAndFatherWhenNotEqualsThenReturnSuccess() throws ParseException {
        Human mother = new Human("Jennifer", "Lopez", "13/08/1910");
        Human father = new Human("Tom", "Cruise", "13/08/1910");
        Family anotherFamily = new Family(mother, father);
        assertNotEquals(anotherFamily, happyFamily);
    }

    @Test
    void addTheSameMotherAndFatherWhenEqualsThenReturnSuccess() throws ParseException {
        Human mother = new Human("Jessica", "Smith", "13/08/1910");
        Human father = new Human("John", "Smith", "13/08/1910");
        Family anotherFamily = new Family(mother, father);
        assertEquals(happyFamily, anotherFamily);
    }

    @Test
    void createFamilyWithTheSameChildWhenEqualsReturnSuccess() throws ParseException {
        addChildToFamily();
        Human mother = new Human("Jessica", "Smith", "13/08/1910");
        Human father = new Human("John", "Smith", "13/08/1910");
        Family anotherFamily = new Family(mother, father);

        Human anderson = new Human(
                "Anderson",
                "Gutenberg",
                198,
                "13/08/1910",
                happyFamily,
                Map.of(MONDAY, "do magic", FRIDAY, "buy a coffee"));

        anotherFamily.addChild(anderson);
        assertEquals(happyFamily, anotherFamily);
    }

    @Test
    void createFamilyWithAnotherChildWhenNotEqualsReturnSuccess() throws ParseException {
        addChildToFamily();
        Human mother = new Human("John", "Smith", "13/08/1910");
        Human father = new Human("Jessica", "Smith", "13/08/1910");
        Family anotherFamily = new Family(mother, father);

        Human fredrich = new Human(
                "Anderson",
                "Gutenberg",
                198,
                "13/08/1910",
                anotherFamily,
                Map.of(MONDAY, "do magic", FRIDAY, "buy a coffee"));

        anotherFamily.addChild(fredrich);
        assertNotEquals(happyFamily, anotherFamily);
    }

}
