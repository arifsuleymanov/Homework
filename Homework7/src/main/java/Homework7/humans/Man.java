package Homework7.humans;

import Homework7.Family;
import Homework7.Human;

public class Man extends Human {

    public Man() {
    }

    public Man(String name, String surname, Integer year, Integer iq) {
        super(name, surname, year, iq);
    }

    public Man(String name, String surname, Integer iq, Integer year, Family family, String[][] schedule) {
        super(name, surname, iq, year, family, schedule);
    }

    @Override
    public void greetPet() {
        System.out.println("Hi my dear.");
    }

    public void swimmingAtPool() {
        System.out.println("Today I am going to swim at pool.");
    }
}
