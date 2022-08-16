package Homework8;

import Homework8.humans.Man;
import Homework8.humans.Woman;
import Homework8.pets.Dog;
import Homework8.pets.DomesticCat;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Woman mother = new Woman("Jessica", "Smith", 1910, 199);
        Man father = new Man("John", "Smith", 27, 200);
        Family happyFamily = new Family(mother, father);
        father.swimmingAtPool();
        mother.goToHospital();
        mother.greetPet();

        Pet domesticCat = new DomesticCat( "Masito", 3, 78, Set.of("meow", "eating", "sleeping"));
        domesticCat.respond();
        Pet dog = new Dog( "Bobik", 5, 87, Set.of("barking", "swimming", "playing"));
        dog.respond();
        Set<Pet> pets = new HashSet<>();
        pets.add(domesticCat);
        pets.add(dog);
        happyFamily.setPet(pets);

        // Advanced level: born a child
        mother.bornChild(happyFamily, father);

        System.out.println(happyFamily);
    }
}
