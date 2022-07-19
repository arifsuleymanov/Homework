package lesson4;

import lesson4.enums.Species;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Pet dog = new Pet(Species.DOG, "Bobik",2,65,new String[]{"barking","eating","sleeping"});
        Human father = new Human("John","Swagger",2000);
        Human mother = new Human("Jessica","Swagger",2010);
        Human child = new Human("Guadeloupe","Fernandez",2010, 200, dog, mother,father, new String[][]{{"friday", "go to the mosque"}});

        System.out.println(child);

        child.greetPet(dog.nickname);
        child.describePet(dog);
        dog.respond(dog.nickname);
        dog.eat();
        dog.foul();
        dog.respond(dog.nickname);


    }
}
