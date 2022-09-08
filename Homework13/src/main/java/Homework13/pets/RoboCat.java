package Homework13.pets;

import Homework13.Pet;
import Homework13.enums.Species;

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
