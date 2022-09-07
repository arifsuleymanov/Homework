package Homework12;

import Homework12.controller.FamilyController;
import Homework12.dao.entity.CollectionFamilyDao;
import Homework12.dao.interfaces.FamilyDao;
import Homework12.humans.Man;
import Homework12.humans.Woman;
import Homework12.pets.Dog;
import Homework12.pets.DomesticCat;
import Homework12.service.FamilyService;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class FamilyApplication {

    private static final FamilyController FAMILY_CONTROLLER = config();



    private static FamilyController config() {
        FamilyDao dao = new CollectionFamilyDao();
        FamilyService service = new FamilyService(dao);
        return new FamilyController(service);
    }

    private void commands() {
        System.out.println(
                "\n" +
                        "****************************************************************************************************************\n"+
                "   - 1. Fill with test data (create several families and save them in the database)\n" +
                "   - 2. Display the entire list of families (displays a list of all families with indexation " +
                       "starting with 1) \n" +
                "   - 3. Display a list of families where the number of people is greater than the specified number\n" +
                "   - 4. Display a list of families where the number of people is less than the specified number\n" +
                "   - 5. Calculate the number of families where the number of members is\n" +
                "   - 6. Create a new family\n" +
                "   - 7. Delete a family by its index in the general list\n" +
                "   - 8. Edit a family by its index in the general list\n" +
                "        - 1. Give birth to a baby\n" +
                "        - 2. Adopt a child\n" +
                "        - 3. Return to main menu '/s \n" +
                "   - 9. Remove all children over the age of majority\n" +
                "   - Exit\n"+
                "***************************************************************************************************************"

        );
    }

    public boolean start() throws ParseException {
        commands();
        System.out.print("Enter command to run: ");
        Scanner in = new Scanner(System.in);
        String select = in.nextLine();

        if (select.equalsIgnoreCase("exit")) {
            System.out.println("Application closed...");
            return false;
        } else {
            switch (select) {
                case "1" : {
                    fillWithTestData();
                    System.out.println("All data successfully saved in database!");
                } break;
                case "2" : {
                    FAMILY_CONTROLLER.displayAllFamilies();
                }break;
                case "3" : FAMILY_CONTROLLER.getFamiliesBiggerThan(requestNumberForOperation()).forEach(System.out::println);break;
                case "4" : FAMILY_CONTROLLER.getFamiliesLessThan(requestNumberForOperation()).forEach(System.out::println);break;
                case "5" :
                    System.out.printf("Result: %d\n",
                            FAMILY_CONTROLLER.countFamiliesWithMemberNumber(requestNumberForOperation()));break;
                case "6" : createFamily();break;
                case "7" : deleteFamilyById();break;
                case "8" : editFamily();break;
                case "9" : FAMILY_CONTROLLER.deleteAllChildrenOlderThan(requestNumberForOperation());break;
                default : System.out.println("Command not exist, try again please!");
            }
        }
        return true;
    }

    private void fillWithTestData() throws ParseException {
        Man john = new Man("John", "Smith", "23/09/2000", 101);
        Woman jessica = new Woman("Jessica", "Smith", "24/09/2002", 50);
        Family smithFamily = FAMILY_CONTROLLER.createNewFamily(jessica, john);

        Man fernando = new Man("Fernando", "Rodriguez", "02/07/2001", 101);
        Woman april = new Woman("April", "Rodriguez", "03/07/2002", 54);
        Family newFamily = FAMILY_CONTROLLER.createNewFamily(april, fernando);

        Set<String> habits = Set.of("barking", "playing", "eating");
        Pet dogMax = new Dog("bobik", 4, 76, habits);
        Pet catCap = new DomesticCat("Cap", 3, 34, habits);

//        FAMILY_CONTROLLER.addPet(smithFamily, dogMax);
//        FAMILY_CONTROLLER.addPet(newFamily, catCap);
        FAMILY_CONTROLLER.bornChild(smithFamily);
        FAMILY_CONTROLLER.bornChild(newFamily);
    }

    private Family createFamily() throws ParseException {

        // mother
        Scanner in = new Scanner(System.in);
        System.out.print("Enter mother's name: ");
        String motherName = in.nextLine();

        System.out.print("Enter mother's surname: ");
        String motherSurname = in.nextLine();

        System.out.print("Enter mother's birth year : ");
        String motherBirthYear = in.nextLine();

        System.out.print("Enter mother's birth month : ");
        String motherBirthMonth = in.nextLine();

        System.out.print("Enter mother's birthday : ");
        String motherBirthDay = in.nextLine();
        String motherBirthDate = motherBirthDay + "/" + motherBirthMonth + "/" + motherBirthYear;

        System.out.print("Enter mother's iq : ");
        int motherIq = in.nextInt();


        // father
        Scanner im = new Scanner(System.in);
        System.out.print("Enter father's name: ");
        String fatherName = im.nextLine();

        System.out.print("Enter father's surname: ");
        String fatherSurname = im.nextLine();

        System.out.print("Enter father's birth year : ");
        String fatherBirthYear = im.nextLine();

        System.out.print("Enter father's birth month : ");
        String fatherBirthMonth = im.nextLine();

        System.out.print("Enter father's birthday : ");
        String fatherBirthDay = im.nextLine();
        String fatherBirthDate = fatherBirthDay + "/" + fatherBirthMonth + "/" + fatherBirthYear;

        System.out.print("Enter father's iq : ");
        int fatherIq = im.nextInt();

        // creating family
        Man father = new Man(fatherName, fatherSurname, fatherBirthDate, fatherIq);
        Woman mother = new Woman(motherName, motherSurname, motherBirthDate, motherIq);

        return FAMILY_CONTROLLER.createNewFamily(mother, father);
    }

    private void deleteFamilyById() {
        Scanner in = new Scanner(System.in);
        System.out.print("enter index of family: ");
        int index = in.nextInt();
        FAMILY_CONTROLLER.deleteFamilyByIndex(index);
    }

    private void editFamily() throws ParseException {
        Scanner im = new Scanner(System.in);

        System.out.print("select from list:\n- 1. Give birth to a baby\n- 2. Adopt a child\n- 3. Return to main menu");
        System.out.print("\nselect: ");

        String select = im.nextLine();
        switch (select) {
            case "1":
                try {
                    Scanner in = new Scanner(System.in);
                    System.out.print("enter index:");
                    FAMILY_CONTROLLER.bornChild(getFamilyById());
                } catch (NullPointerException ex) {
                    System.out.println("null");
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println("family doesn't exist");
                }
                break;
            case "2":
                try {
                    FAMILY_CONTROLLER.adoptChild(getFamilyById(), adoptChild());
                } catch (NullPointerException ex) {
                    System.out.println("null");
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println("family doesn't exist");
                }
                break;
            case "3":
                start();
            default:
                System.out.println("try again!");
        }
    }

    private Family getFamilyById() {
        Scanner in = new Scanner(System.in);
        System.out.print("enter index: ");
        int index = in.nextInt();
        return FAMILY_CONTROLLER.getFamilyById(index);
    }

    private int requestNumberForOperation() {
        Scanner in = new Scanner(System.in);
        System.out.print("enter number for operation: ");
        return in.nextInt();
    }

    private Human adoptChild() throws ParseException {
        Scanner in = new Scanner(System.in);

        System.out.print("child's name is: ");
        String name = in.nextLine();

        System.out.print("child's surname is: ");
        String surname = in.nextLine();

        System.out.print("child's birthdate (dd/mm/yyyy): ");
        String birthDate = in.nextLine();

        System.out.print("child's IQ is: ");
        int iq = in.nextInt();
        in.nextLine();

        System.out.print("child's gender is: ");
        String gender = in.nextLine();

        Human adoptedChild = new Human(name, surname, birthDate, iq);
        adoptedChild.setGender(gender);
        return adoptedChild;
    }
}
