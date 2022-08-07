package homework6;


import homework6.enums.Species;

import static homework6.enums.DayOfWeek.*;

public class Main {
    public static void main(String[] args) {

        // adding mother, father and pet => creating a family
        Human mother = new Human("Jessica", "Smith", 1910);
        Human father = new Human("John", "Smith", 1900);
        Family happyFamily = new Family(mother, father);
        Pet pet = new Pet(Species.DOG, "Bobik", 11, 56, new String[]{"barking", "eating", "sleeping"});
        happyFamily.setPet(pet);

        // creating and adding child1
        Human anderson = new Human(
                "Anderson",
                "Gutenberg",
                198,
                100,
                happyFamily,
                new String[][]{{MONDAY.name(), "do magic"}, {FRIDAY.name(), "buy a coffee"}});
        happyFamily.addChild(anderson);

        // creating and adding child2
        Human fisher = new Human(
                "Fisher",
                "Mayer",
                167,
                100,
                happyFamily,
                new String[][]{{THURSDAY.name(), "fly in the sky"}});
        happyFamily.addChild(fisher);

        // deleting a child by index
        // uncomment this to delete children
        happyFamily.deleteChildByIndex(1);
        happyFamily.deleteChildByHuman(anderson);


        // print family
        System.out.println(happyFamily + " = " + happyFamily.countFamily(happyFamily));

        // creating and adding child3
        Human rodrigez = new Human(
                "Rodrigez",
                "Lafayetta",
                105,
                76,
                happyFamily,
                new String[][]{{THURSDAY.name(), "go to the cinema"}});
        happyFamily.addChild(rodrigez);

        // print family
        System.out.println(happyFamily + " = " + happyFamily.countFamily(happyFamily));

        // Garbage Collector
//        humanGC();
    }

    public static void humanGC() {
        for (int i = 0; i < 999999; i++) {
            Human human = new Human();
        }
    }

}
