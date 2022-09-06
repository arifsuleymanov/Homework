package Homework11.humans;


import Homework11.Family;
import Homework11.Human;
import Homework11.enums.DayOfWeek;

import java.text.ParseException;
import java.util.Map;

public class Man extends Human {

    public Man() {
    }

    public Man(String name,
               String surname,
               String birthDate,
               Integer iq) throws ParseException {
        super(name, surname, birthDate, iq);
    }

    public Man(String name,
               String surname,
               Integer iq,
               String birthDate,
               Family family,
               Map<DayOfWeek, String> schedule) throws ParseException{
        super(name, surname, iq, birthDate, family, schedule);
    }

    @Override
    public void greetPet() {
        System.out.println("Hi my dear.");
    }

    public void swimmingAtPool() {
        System.out.println("Today I am going to swim at pool.");
    }

}
