package homework5;

import homework5.enums.Species;

public class Main {
    public static void main(String[] args) {
        Pet pet = new Pet(Species.DOG, "Bobik", 11, 56, new String[]{"barking", "eating", "sleeping"});

        Human mother = new Human("Jessica", "Smith", 1910);
        Human father = new Human("John", "Smith", 1900);
        Family happyFamily = new Family(mother, father);

        Human anderson = new Human("Anderson", "Gutenberg", 198, 100, happyFamily, new String[][]{{"monday", "do " +
                "magic"}, {"friday", "buy a coffee"}});
        Human fisher = new Human("Fisher", "Mayer", 167, 100, happyFamily, new String[][]{{"monday, fly in the sky"}});

        happyFamily.setPet(pet);
        happyFamily.addChild(anderson);
        happyFamily.addChild(fisher);

        happyFamily.deleteChild(1);
        System.out.println(happyFamily + " = " + happyFamily.countFamily(happyFamily));

    }
}
