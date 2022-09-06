package Homework11.humans;

import Homework11.Family;
import Homework11.Human;
import Homework11.enums.DayOfWeek;
import Homework11.interfaces.HumanCreator;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Woman extends Human implements HumanCreator {

    public Woman() {
    }

    public Woman(String name, String surname, String birthDate) throws ParseException{
        super(name, surname, birthDate);
    }

    public Woman(String name, String surname, String birthDate, Integer iq) throws ParseException {
        super(name, surname, birthDate, iq);
    }

    public Woman(String name, String surname, Integer iq, String birthDate, Family family, Map<DayOfWeek, String> schedule) throws ParseException {
        super(name, surname, iq, birthDate, family, schedule);
    }

    @Override
    public void greetPet() {
        System.out.println("Hi my best friend!");
    }

    public void goToHospital() {
        System.out.println("Every 6 months I visit family doctor.");
    }

    // Advanced level: Overriding from HumanCreator interface
    @Override
    public Human bornChild(Family family, Human father) throws ParseException {
        Human child = genderDetermination();

        child.setName(childRandomName(child));
        child.setSurname(father.getSurname());
        child.setIq((family.getFather().getIq()+family.getMother().getIq())/2);
        child.setBirthDate("12/07/2009");
        child.setGender(genderDetermination().getGender());
        child.setFamily(family);
        child.getFamily().setMother(this);
        child.getFamily().setFather(father);
        family.addChild(child);

        return child;
    }

    // Advanced level: gender determination
    public Human genderDetermination() {
        Random random = new Random();
        List<Human> genders = List.of(new Man(),new Woman());
        return genders.get(random.nextInt(2));
    }

    // Advanced level: name determination
    public String childRandomName(Human child) {
        Random random = new Random();
        List<String> maleNames = List.of("James", "Mayer", "Michael", "Rodriguez", "Padre");
        List<String> femaleNames = List.of("Kleopatra", "Anksunamun", "Jennifer", "April", "Catrin");

        return (child instanceof Man ) ? maleNames.get(random.nextInt(4)) : femaleNames.get(random.nextInt(4));

    }
}
