package Homework10.pets;

import Homework10.Pet;
import Homework10.interfaces.Foul;

import java.util.Set;

public class Dog extends Pet implements Foul {

    public Dog() {
        super.setSpecies(Species.DOG);
    }

    public Dog(String nickname, Integer age, Integer trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.DOG);
    }

    @Override
    public void foul() {
        System.out.println(this.getNickname() + " fouled at the park!");
    }

    @Override
    public void respond() {
        System.out.println(this.getNickname() + " ham ham");
    }

}
