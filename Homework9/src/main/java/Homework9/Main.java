package Homework9;


import Homework9.controller.FamilyController;
import Homework9.dao.entity.CollectionFamilyDao;
import Homework9.dao.interfaces.FamilyDao;
import Homework9.humans.Man;
import Homework9.humans.Woman;
import Homework9.pets.Dog;
import Homework9.pets.DomesticCat;
import Homework9.service.FamilyService;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        FamilyController familyController = config();

        Woman mother = new Woman("Jessica", "Smith", 1910, 199);
        Man father = new Man("John", "Smith", 27, 200);
//        Family happyFamily = new Family(mother, father);
//        father.swimmingAtPool();
//        mother.goToHospital();
//        mother.greetPet();
//
//        Pet domesticCat = new DomesticCat( "Masito", 3, 78, Set.of("meow", "eating", "sleeping"));
//        domesticCat.respond();
//        Pet dog = new Dog( "Bobik", 5, 87, Set.of("barking", "swimming", "playing"));
//        dog.respond();
//        Set<Pet> pets = new HashSet<>();
//        pets.add(domesticCat);
//        pets.add(dog);
//        happyFamily.setPet(pets);
//
//        // Advanced level: born a child
//        mother.bornChild(happyFamily, father);

//        System.out.println(happyFamily);
    }

    private static FamilyController config() {
        FamilyDao familyDao = new CollectionFamilyDao();
        FamilyService familyService = new FamilyService(familyDao);
        return new FamilyController(familyService);
    }
}
