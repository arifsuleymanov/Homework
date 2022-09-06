package Homework9;

import Homework9.pets.Species;

import java.util.Objects;
import java.util.Set;

public abstract class Pet {
    private Species species;
    private String nickname;
    private Integer age;
    private Integer trickLevel;
    private Set<String> habits;

    public Pet() {
    }

    public Pet(String nickname) {
        this.nickname = nickname;
        this.species = Species.UNKNOWN;
    }

    public Pet(String nickname, Integer age, Integer trickLevel, Set<String> habits) {
        this.species = Species.UNKNOWN;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(Integer trickLevel) {
        this.trickLevel = trickLevel;
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    @Override
    public String toString() {
        return  species.name().toLowerCase() +
                species.toString().toLowerCase()  +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + habits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return species == pet.species && Objects.equals(nickname, pet.nickname) && Objects.equals(age, pet.age) && Objects.equals(trickLevel, pet.trickLevel) && Objects.equals(habits, pet.habits);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(species, nickname, age, trickLevel);
        result = 31 * result + habits.hashCode();
        return result;
    }

    public void eat() {
        System.out.println("I am eating");
    }

    public abstract void respond();

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.nickname + " object collected by Garbage Collector");
    }

}
