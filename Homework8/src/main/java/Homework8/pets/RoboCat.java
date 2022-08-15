package Homework8.pets;

import Homework7.Pet;
import Homework7.enums.Species;

public class RoboCat extends Pet {

    public RoboCat() {
        super.setSpecies(Species.ROBO_CAT);
    }

    public RoboCat(String nickname, Integer age, Integer trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.ROBO_CAT);
    }

    @Override
    public void respond() {
        System.out.println(this.getNickname() + ": hi, my lord");
    }
}
