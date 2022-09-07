package Homework12.pets;


import Homework12.Pet;
import Homework12.enums.Species;

import java.util.Set;

public class Fish extends Pet {

    public Fish() {
        super.setSpecies(Species.FISH);
    }

    public Fish(String nickname, Integer age, Integer trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.FISH);
    }

    @Override
    public void respond() {
        System.out.println(this.getNickname() + " is angry to you");
    }

}
