package Homework12.pets;

import Homework12.Pet;
import Homework12.enums.Species;
import Homework12.interfaces.Foul;

import java.util.Set;

public class DomesticCat extends Pet implements Foul {

    public DomesticCat() {
        super.setSpecies(Species.DOMESTIC_CAT);
    }

    public DomesticCat(String nickname, Integer age, Integer trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.DOMESTIC_CAT);
    }

    @Override
    public void foul() {

    }

    @Override
    public void respond() {
        System.out.println(this.getNickname() + " miyau");
    }

}
