package Homework8;


import Homework7.humans.Man;
import Homework7.humans.Woman;
import Homework7.pets.Dog;
import Homework7.pets.DomesticCat;

public class Main {
    public static void main(String[] args) {

        Woman mother = new Woman("Jessica", "Smith", 1910, 199);
        Man father = new Man("John", "Smith", 27, 200);
        Family happyFamily = new Family(mother, father);

        Pet domesticCat = new DomesticCat( "Masito", 3, 78, new String[]{"meow", "eating", "sleeping"});
        domesticCat.respond();
        happyFamily.setPet(domesticCat);

        Pet dog = new Dog( "Bobik", 5, 87, new String[]{"barking", "swimming", "playing"});
        dog.respond();
        happyFamily.setPet(dog);

        // Advanced level: born a child
        mother.bornChild(happyFamily, father);

        System.out.println(happyFamily);
    }
}
