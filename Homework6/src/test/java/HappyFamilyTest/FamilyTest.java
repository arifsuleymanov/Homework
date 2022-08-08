package HappyFamilyTest;

import homework6.Family;
import homework6.Human;
import homework6.Pet;
import homework6.enums.Species;
import org.junit.jupiter.api.Test;

import static homework6.enums.DayOfWeek.FRIDAY;
import static homework6.enums.DayOfWeek.MONDAY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FamilyTest {
    Human mother = new Human("Jessica", "Smith", 1910);
    Human father = new Human("John", "Smith", 1900);
    Family happyFamily = new Family(mother, father);
    Pet pet = new Pet(Species.DOG, "Bobik", 11, 56, new String[]{"barking", "eating", "sleeping"});
    Human anderson = new Human(
            "Anderson",
            "Gutenberg",
            198,
            100,
            happyFamily,
            new String[][]{{MONDAY.name(), "do magic"}, {FRIDAY.name(), "buy a coffee"}});

    Human[] addChildToFamily() {
        happyFamily.addChild(anderson);
        return  happyFamily.getChildren();
    }

    @Test
    void givenCountFamilyReturnSuccess() {
        addChildToFamily();
        assertEquals(3, happyFamily.countFamily(happyFamily));
    }

    @Test
    void givenDeleteChildByIndexWhenDeletedThenReturnSuccess() {
        addChildToFamily();
        happyFamily.deleteChildByIndex(0);
        assertEquals(0, this.happyFamily.getChildren().length);
    }

    @Test
    void givenDeleteChildByIndexWhenIndexIsWrong() {
        addChildToFamily();
        happyFamily.deleteChildByIndex(3);
        assertEquals(1, this.happyFamily.getChildren().length);
    }

    @Test
    void givenDeleteChildByHumanThenReturnSuccess() {
        addChildToFamily();
        happyFamily.deleteChildByHuman(this.anderson);
        assertEquals(0, this.happyFamily.getChildren().length);
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
                new String[][]{{MONDAY.name(), "do magic"}, {FRIDAY.name(), "buy a coffee"}});
        happyFamily.deleteChildByHuman(anderson);
        assertEquals(0, this.happyFamily.getChildren().length);
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
                new String[][]{{MONDAY.name(), "do magic"}, {FRIDAY.name(), "buy a coffee"}});

        anotherFamily.addChild(anderson);
        assertEquals(happyFamily, anotherFamily);
    }

    @Test
    void createFamilyWithAnotherChildWhenNotEqualsReturnSuccess() {
        addChildToFamily();
        Human mother = new Human("Jane", "Maxwell", 1977);
        Human father = new Human("John", "Maxwell", 1973);
        Family anotherFamily = new Family(mother, father);

        Human fredrich = new Human(
                "Anderson",
                "Gutenberg",
                198,
                100,
                anotherFamily,
                new String[][]{{MONDAY.name(), "do magic"}, {FRIDAY.name(), "buy a coffee"}});

        anotherFamily.addChild(fredrich);
        assertNotEquals(happyFamily, anotherFamily);
    }
}
