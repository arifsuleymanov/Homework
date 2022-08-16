package Homework8.pets;

import Homework8.Pet;
import Homework8.enums.Species;

import java.util.Set;

public class RoboCat extends Pet {

    public RoboCat() {
        super.setSpecies(Species.ROBO_CAT);
    }

    public RoboCat(String nickname, Integer age, Integer trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.ROBO_CAT);
    }

    @Override
    public void respond() {
        System.out.println(this.getNickname() + ": hi, my lord");
    }
}
