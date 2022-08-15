package Homework7.pets;

import Homework7.Pet;
import Homework7.enums.Species;

public class Fish extends Pet {

    public Fish() {
        super.setSpecies(Species.FISH);
    }

    public Fish(String nickname, Integer age, Integer trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.FISH);
    }

    @Override
    public void respond() {
        System.out.println(this.getNickname() + " is angry to you");
    }
}
