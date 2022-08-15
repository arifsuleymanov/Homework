package Homework8;

import Homework7.humans.Man;

import java.util.Map;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private Integer year;
    private Integer iq;
    private String gender;
    private Family family;
    private Map<String, String> schedule;

    public Human() {
    }

    public Human(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;

        if (this instanceof Man) {
            this.gender = "Man";
        } else {
            this.gender = "Woman";
        }
    }

    public Human(String name, String surname, Integer year, Integer iq) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;

        if (this instanceof Man) {
            this.gender = "Man";
        } else {
            this.gender = "Woman";
        }
    }

    public Human(String name, String surname, Integer year, Integer iq, Family family) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.family = family;

        if (this instanceof Man) {
            this.gender = "Man";
        } else {
            this.gender = "Woman";
        }
    }

    public Human(String name, String surname, Integer iq, Integer year, Family family, Map<String, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        this.year = year;
        this.family = family;
        this.schedule = schedule;

        if (this instanceof Man) {
            this.gender = "Man";
        } else {
            this.gender = "Woman";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {

        if (this instanceof Man) {
            this.gender = "Man";
        } else {
            this.gender = "Woman";
        }

    }

    public Integer getIq() {
        return iq;
    }

    public void setIq(Integer iq) {
        this.iq = iq;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Map<String, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, String> schedule) {
        this.schedule = schedule;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this + " object collected by Garbage Collector");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(year, human.year);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, year, iq, family);
        result = 31 * result + schedule.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + schedule +
                '}';
    }

    public void greetPet() {
        System.out.println("Hi pet");
    }
}

