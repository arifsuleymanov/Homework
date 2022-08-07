package lesson4;

public class Human extends Pet{
    public String name;
    public String surname;
    public Integer iq;
    public Integer year;
    public Pet pet;
    public Human mother;
    public Human father;
    public String[][] schedule;

    public Human() {
    }

    public Human(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, Integer year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, Integer iq, Integer year, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        this.year = year;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    public void greetPet(String petName) {
        System.out.println("Hello, "+petName);
    }

    public void describePet(Pet pet) {
        System.out.printf("I have %s, he is %d years old, he is %s. ",pet.species.toString().toLowerCase(), pet.age, (pet.trickLevel>50)?"very sly":"almost not sly");
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", iq=" + iq +
                ", year=" + year +
                ", mother=" + mother.name +
                ", father=" + father.name +
                ", pet=" + pet +
                '}';
    }
}

