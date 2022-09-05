package Homework9.pets;

import Homework9.Pet;
import Homework9.interfaces.Foul;

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
