package Homework7.humans;

import Homework7.Family;
import Homework7.Human;
import Homework7.interfaces.HumanCreator;

import java.util.List;
import java.util.Random;

public class Woman extends Human implements HumanCreator {

    public Woman() {
    }

    public Woman(String name, String surname, Integer year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, Integer year, Integer iq) {
        super(name, surname, year, iq);
    }

    public Woman(String name, String surname, Integer iq, Integer year, Family family, String[][] schedule) {
        super(name, surname, iq, year, family, schedule);
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
    public Human bornChild(Family family, Human father) {
        Human child = genderDetermination();

        child.setName(childRandomName(child));
        child.setSurname(father.getSurname());
        child.setIq((family.getFather().getIq()+family.getMother().getIq())/2);
        child.setYear(2020);
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
        List<String> maleNames = List.of("James", "John", "Michael", "Rodriguez", "Padre");
        List<String> femaleNames = List.of("Kleopatra", "Anksunamun", "Jennifer", "April", "Catrin");

        return (child instanceof Man ) ? maleNames.get(random.nextInt(4)) : femaleNames.get(random.nextInt(4));
    }
}
