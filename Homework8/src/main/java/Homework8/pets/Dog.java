package Homework8.pets;

import Homework7.Pet;
import Homework7.enums.Species;
import Homework7.interfaces.Foul;

public class Dog extends Pet implements Foul {

    public Dog() {
        super.setSpecies(Species.DOG);
    }

    public Dog(String nickname, Integer age, Integer trickLevel, String[] habits) {
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
