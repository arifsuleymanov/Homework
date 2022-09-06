package Homework9.humans;


import Homework9.Family;
import Homework9.Human;
import Homework9.enums.DayOfWeek;
import Homework9.Human;

import java.util.Map;

public class Man extends Human {

    public Man() {
    }

    public Man(String name, String surname, Integer year, Integer iq) {
        super(name, surname, year, iq);
    }

    public Man(String name, String surname, Integer iq, Integer year, Family family, Map<DayOfWeek, String> schedule) {
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
