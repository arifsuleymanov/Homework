package Homework11;


import Homework11.enums.DayOfWeek;
import Homework11.humans.Man;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private long birthDate;
    private Integer iq;
    private String gender;
    private Family family;
    private Map<DayOfWeek, String> schedule;
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public Human() {
        if (this instanceof Man) {
            this.gender = "Man";
        } else {
            this.gender = "Woman";
        }
    }

    public Human(String name, String surname, String birthDate) throws ParseException{
        this.name = name;
        this.surname = surname;
        this.birthDate = getParsedDate(birthDate).getTime();

        if (this instanceof Man) {
            this.gender = "Man";
        } else {
            this.gender = "Woman";
        }
    }

    public Human(String name, String surname, String birthDate, Integer iq) throws ParseException {
        this.name = name;
        this.surname = surname;
        this.birthDate = getParsedDate(birthDate).getTime();
        this.iq = iq;

        if (this instanceof Man) {
            this.gender = "Man";
        } else {
            this.gender = "Woman";
        }
    }

    public Human(String name, String surname, String birthDate, Integer iq, Family family) throws ParseException{
        this.name = name;
        this.surname = surname;
        this.birthDate = getParsedDate(birthDate).getTime();
        this.iq = iq;
        this.family = family;

        if (this instanceof Man) {
            this.gender = "Man";
        } else {
            this.gender = "Woman";
        }
    }

    public Human(String name, String surname, Integer iq, String birthDate, Family family,
                 Map<DayOfWeek, String> schedule) throws ParseException{
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        this.birthDate = getParsedDate(birthDate).getTime();
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

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) throws ParseException{
        this.birthDate = getParsedDate(birthDate).getTime();
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

    public Map<DayOfWeek, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DayOfWeek, String> schedule) {
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
        return Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(birthDate, human.birthDate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, birthDate, iq, family);
        result = 31 * result + schedule.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + SIMPLE_DATE_FORMAT.format(birthDate) +
                ", iq=" + iq +
                ", schedule=" + schedule +
                '}';
    }

    public void greetPet() {
        System.out.println("Hi pet");
    }

    private Date getParsedDate(String birthDate) throws ParseException {
        return SIMPLE_DATE_FORMAT.parse(birthDate);
    }

    public void describeAge() {
        long current = System.currentTimeMillis()/1000;
        long duration = current - (birthDate/1000);
        long days = duration/86400;
        long months = days/30;
        long years = months/12;

        System.out.printf("years = %d, months = %d, days = %d", years, months, days);
    }

    public int getBirthYear() throws ParseException {
        return getParsedDate(SIMPLE_DATE_FORMAT.format(birthDate)).getYear();
    }

    public int getAge() {
        String year = SIMPLE_DATE_FORMAT.format(birthDate).substring(6); //yyyy
        return LocalDate.now().getYear() - Integer.parseInt(year);
    }
}

