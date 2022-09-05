package HappyFamilyTest;

import Homework9.Family;
import Homework9.Human;
import Homework9.dao.entity.CollectionFamilyDao;
import Homework9.dao.interfaces.FamilyDao;
import Homework9.humans.Man;
import Homework9.humans.Woman;
import Homework9.service.FamilyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyServiceTest {
    private Woman mother;
    private Man father;
    private Family family;
    private FamilyService service;

    @BeforeEach
    void setUp() {
        FamilyDao familyDao = new CollectionFamilyDao();
        service = new FamilyService(familyDao);
        father = new Man("John", "Smith", 2001, 76);
        mother = new Woman("Jessica", "Smith", 2003, 55);
    }

    @Test
    void countingFamiliesTest() {
        family = service.createNewFamily(mother, father);
        assertEquals(1, service.count());
    }

    @Test
    void deleteChildOlderThan() {
        Human child = new Man("Child", "Adopt", 2010, 99);
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
    void adoptingChildTest() {
        Human child = new Man("Child", "Adopt", 2010, 99);
        family = service.createNewFamily(mother, father);
        service.bornChild(family);
        service.adoptChild(family, child);
        assertEquals(2, service.getFamilyById(0).getChildren().size());
    }

    @Test
    void countFamiliesWithMemberNumberTest() {
        Human child = new Man("Child", "Adopt", 2010, 99);
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
    void getFamiliesLessThanFourTest() {
        family = service.createNewFamily(mother, father);
        service.bornChild(family);
        assertEquals(1, service.getFamiliesLessThan(4).size());
    }

    @Test
    void getFamiliesBiggerThanTwoTest() {
        family = service.createNewFamily(mother, father);
        service.bornChild(family);
        assertEquals(1, service.getFamiliesBiggerThan(2).size());
    }

    @Test
    void bornChildTest() {
        family = service.createNewFamily(mother, father);
        service.bornChild(family);
        assertEquals(1, service.getFamilyById(0).getChildren().size());
    }
}
