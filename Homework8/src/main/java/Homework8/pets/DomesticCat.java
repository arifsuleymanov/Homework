package Homework8.pets;

import Homework8.Pet;
import Homework8.enums.Species;
import Homework8.interfaces.Foul;

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
