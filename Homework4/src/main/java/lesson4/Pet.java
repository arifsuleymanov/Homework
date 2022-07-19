package lesson4;

import lesson4.enums.Species;

import java.util.Arrays;

public class Pet {
    public Species species;
    public String nickname;
    public Integer age;
    public Integer trickLevel;
    public String[] habits;

    public Pet() {
    }

    public Pet(Species species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(Species species, String nickname, Integer age, Integer trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public void eat() {
        System.out.println("I am eating");
    }

    public void respond(String nickname){
        System.out.println("Hello, owner. I am - "+ nickname+(". I miss you!"));
    }

    public void foul() {
        System.out.println("I need to cover it up");
    }

    @Override
    public String toString() {
        return  species.toString().toLowerCase() + "{" +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }
}
