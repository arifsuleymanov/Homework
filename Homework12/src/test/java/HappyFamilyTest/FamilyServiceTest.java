package HappyFamilyTest;

import Homework12.Family;
import Homework12.Human;
import Homework12.dao.entity.CollectionFamilyDao;
import Homework12.dao.interfaces.FamilyDao;
import Homework12.humans.Man;
import Homework12.humans.Woman;
import Homework12.service.FamilyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyServiceTest {
    private Woman mother;
    private Man father;
    private Family family;
    private FamilyService service;

    @BeforeEach
    void setUp() throws ParseException {
        FamilyDao familyDao = new CollectionFamilyDao();
        service = new FamilyService(familyDao);
        father = new Man("John", "Smith", "12/08/2000", 76);
        mother = new Woman("Jessica", "Smith", "13/08/2000", 55);
    }

    @Test
    void countingFamiliesTest() {
        family = service.createNewFamily(mother, father);
        assertEquals(1, service.count());
    }

    @Test
    void deleteChildOlderThan() throws ParseException {
        Human child = new Man("Child", "Adopt", "13/08/2009", 99);
        family = service.createNewFamily(mother, father);
        service.adoptChild(family, child);
        service.deleteAllChildrenOlderThan(10);
        assertEquals(0, service.getFamilyById(0).getChildren().size());
    }

    @Test
    void deletingFamilyTest() {
        family = service.createNewFamily(mother, father);
        service.deleteFamilyByIndex(0);
        assertEquals(0, service.count());
    }

    @Test
    void adoptingChildTest() throws ParseException {
        Human child = new Man("Henry", "Mayer", "13/08/2009", 99);
        family = service.createNewFamily(mother, father);
        service.bornChild(family);
        service.adoptChild(family, child);
        assertEquals(2, service.getFamilyById(0).getChildren().size());
    }

    @Test
    void countFamiliesWithMemberNumberTest() throws ParseException {
        Human child = new Man("Henry", "Mayer", "13/08/2008", 99);
        family = service.createNewFamily(mother, father);
        service.bornChild(family);
        service.adoptChild(family, child);
        assertEquals(1, service.countFamiliesWithMemberNumber(4));
    }

    @Test
    void creatingNewFamilyTest() {
        family = service.createNewFamily(mother, father);
        assertEquals(1, service.count());
    }

    @Test
    void countingFamiliesWithSameMembers() {
        Family family1 = service.createNewFamily(mother, father);
        family = service.createNewFamily(mother, father);
        assertEquals(1, service.count());
    }

    @Test
    void getFamiliesLessThanFourTest() throws ParseException {
        family = service.createNewFamily(mother, father);
        service.bornChild(family);
        assertEquals(1, service.getFamiliesLessThan(4).size());
    }

    @Test
    void getFamiliesBiggerThanTwoTest() throws ParseException {
        family = service.createNewFamily(mother, father);
        service.bornChild(family);
        assertEquals(1, service.getFamiliesBiggerThan(2).size());
    }

    @Test
    void bornChildTest() throws ParseException {
        family = service.createNewFamily(mother, father);
        service.bornChild(family);
        assertEquals(1, service.getFamilyById(0).getChildren().size());

    }
}
