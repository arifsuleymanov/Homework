package Homework9;


import Homework9.controller.FamilyController;
import Homework9.dao.entity.CollectionFamilyDao;
import Homework9.dao.interfaces.FamilyDao;
import Homework9.humans.Man;
import Homework9.humans.Woman;
import Homework9.pets.Dog;
import Homework9.pets.DomesticCat;
import Homework9.pets.Fish;
import Homework9.service.FamilyService;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        FamilyController familyController = config();

        Set<String> habits = Set.of("barking", "sleeping", "playing");
        Pet bobby = new Dog("bobby", 1, 23, habits);
        Pet catty = new DomesticCat("catty", 2, 67, habits);
        Pet futty = new Fish("Futty", 3, 11, habits);

        Woman motherJessicca = new Woman("Jessica", "Smith", 1910, 199);
        Man fatherJohn = new Man("John", "Smith", 27, 200);
        Family smithFamily = new Family(motherJessicca, fatherJohn);
        Human adoptedChild = new Woman("Cristina", "Fernandez", 2009, 79);

        // controller
        Family familySmith = familyController.createNewFamily(motherJessicca, fatherJohn);
        familyController.bornChild(familySmith);
        familyController.adoptChild(smithFamily, adoptedChild);
        familyController.bornChild(smithFamily);
        familyController.bornChild(smithFamily);
        familyController.bornChild(smithFamily);
        familyController.bornChild(smithFamily);
        familyController.bornChild(smithFamily);
        familyController.bornChild(smithFamily);
        familyController.bornChild(smithFamily);
//        familyController.addPet(smithFamily, bobby);
//        familyController.addPet(smithFamily, catty);
//        familyController.addPet(smithFamily, futty);
        familyController.displayAllFamilies();
        familyController.getAllfamilies();
        familyController.count();
        familyController.getFamiliesBiggerThan(1);
        familyController.getFamiliesLessThan(1);
        familyController.countFamiliesWithMemberNumber(3);
        familyController.deleteFamilyByIndex(0);
        familyController.deleteAllChildrenOlderThan(2);
        familyController.getFamilyById(0);
//        familyController.getPets(smithFamily);





    }

    private static FamilyController config() {
        FamilyDao familyDao = new CollectionFamilyDao();
        FamilyService familyService = new FamilyService(familyDao);
        return new FamilyController(familyService);
    }
}
