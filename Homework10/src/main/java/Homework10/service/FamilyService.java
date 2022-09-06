package Homework10.service;

import Homework10.Family;
import Homework10.Human;
import Homework10.dao.interfaces.FamilyDao;
import Homework10.humans.Man;
import Homework10.humans.Woman;

import java.text.ParseException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FamilyService {

    private final FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        int[] count = {1};
        getAllFamilies().stream()
                .map(x -> count[0]++ + "." + x)
                .forEach(System.out::println);
    }

    public List<Family> getFamiliesBiggerThan(int membersCount) {
        return getAllFamilies().stream()
                .filter(x -> x.countFamily() > membersCount)
                .collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int membersCount) {
        return getAllFamilies().stream()
                .filter(x -> x.countFamily() < membersCount)
                .collect(Collectors.toList());
    }

    public int countFamiliesWithMemberNumber(int num) {
        int[] count = {0};
        getAllFamilies().forEach(x -> {
            if (x.countFamily() == num) {
                count[0]++;
            }
        });
        return count[0];
    }

    public Family createNewFamily(Woman mother, Man father) {
        Family family = new Family(mother, father);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteFamilyByIndex(int index) {
        if (familyDao.deleteFamily(index)) {
            System.out.println("Family succesfully deleted from database!");
        } else {
            System.out.println("This family doesn't exist in database!");
        }
    }

    public Family bornChild(Family family) throws ParseException {
        Human child = genderDetermination();

        child.setName(childRandomName(child));
        child.setSurname(family.getFather().getSurname());
        child.setIq((family.getFather().getIq()+family.getMother().getIq())/2);
        child.setGender(genderDetermination().getGender());
        child.setFamily(family);
        child.getFamily().setMother(family.getMother());
        child.getFamily().setFather(family.getFather());

        Random rn = new Random();
        if (family.getChildren().size()==0 || family.getChildren().size()==1) {
            child.setBirthDate("14/08/2008");
        } else {
            child.setBirthDate("11/06/200" + rn.nextInt(4));
        }

        family.addChild(child);
        familyDao.saveFamily(family);

        return family;
    }

    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        child.setFamily(family);
        familyDao.saveFamily(family);

        return family;
    }

    public void deleteAllChildrenOlderThan(int age) {
        getAllFamilies().forEach(x -> {
            List<Human> childrenList = x.getChildren();
            childrenList.removeIf(human -> human.getAge() > age);
            familyDao.saveFamily(x);
        });
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    // null pointer exception(due to work I don't have time to fix it)
//    public List<Pet> getPets(Family family) {
//        List<Pet> petList = new ArrayList<>();
//
//        getAllFamilies().forEach(x -> {
//            if (x.equals(family)) {
//                petList.addAll(family.getPet());
//            }
//        });
//        return petList;
//    }
      // null pointer exception(due to work I don't have time to fix it)
//    public void addPet(Family family, Pet pet) {
//        getAllFamilies().forEach(x -> {
//            family.getPet().add(pet);
//            familyDao.saveFamily(x);
//        });
//    }

    private Human genderDetermination() {
        Random random = new Random();
        List<Human> genders = List.of(new Man(),new Woman());
        return genders.get(random.nextInt(2));
    }

    private String childRandomName(Human child) {
        Random random = new Random();
        List<String> maleNames = List.of("James", "Mayer", "Michael", "Rodriguez", "Padre");
        List<String> femaleNames = List.of("Kleopatra", "Anksunamun", "Jennifer", "April", "Catrin");

        return (child instanceof Man ) ? maleNames.get(random.nextInt(4)) : femaleNames.get(random.nextInt(4));
    }





}
