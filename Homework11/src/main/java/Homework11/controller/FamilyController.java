package Homework11.controller;

import Homework11.Family;
import Homework11.Human;
import Homework11.humans.Man;
import Homework11.humans.Woman;
import Homework11.service.FamilyService;

import java.text.ParseException;
import java.util.List;

public class FamilyController {

    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public List<Family> getAllfamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public int count () {
        return familyService.count();
    }

    public Family bornChild(Family family) throws ParseException {
        return familyService.bornChild(family);
    }

    public Family adoptChild(Family family, Human child) {
        return familyService.adoptChild(family, child);
    }

    public Family createNewFamily(Woman mother, Man father) {
        return familyService.createNewFamily(mother, father);
    }

    public void deleteFamilyByIndex(int index) {
        familyService.deleteFamilyByIndex(index);
    }

    public List<Family> getFamiliesBiggerThan(int membersCount) {
        return familyService.getFamiliesBiggerThan(membersCount);
    }

    public List<Family> getFamiliesLessThan(int membersCount) {
        return familyService.getFamiliesLessThan(membersCount);
    }

    public int countFamiliesWithMemberNumber(int num) {
        return familyService.countFamiliesWithMemberNumber(num);
    }

    public void deleteAllChildrenOlderThan(int age) {
        familyService.deleteAllChildrenOlderThan(age);
    }

    public Family getFamilyById(int index) {
        return familyService.getFamilyById(index);
    }

    // null pointer exception(due to work I don't have time to fix it)
//    public List<Pet> getPets(Family family) {
//        return familyService.getPets(family);
//    }



    // null pointer exception(due to work I don't have time to fix it)
//    public void addPet(Family family, Pet pet) {
//        familyService.addPet(family, pet);
//    }
}
