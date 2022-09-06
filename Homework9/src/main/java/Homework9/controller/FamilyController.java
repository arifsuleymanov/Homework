package Homework9.controller;

import Homework9.Family;
import Homework9.Human;
import Homework9.humans.Man;
import Homework9.humans.Woman;
import Homework9.service.FamilyService;

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

    public List<Family> getFamiliesBiggerThan(int membersCount) {
        return familyService.getFamiliesBiggerThan(membersCount);
    }

    public List<Family> getFamiliesLessThan(int membersCount) {
        return familyService.getFamiliesLessThan(membersCount);
    }

    public int countFamiliesWithMemberNumber(int num) {
        return familyService.countFamiliesWithMemberNumber(num);
    }

    public Family createNewFamily(Woman mother, Man father) {
        return familyService.createNewFamily(mother, father);
    }

    public void deleteFamilyByIndex(int index) {
        familyService.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family) {
        return familyService.bornChild(family);
    }

    public Family adoptChild(Family family, Human child) {
        return familyService.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThan(int age) {
        familyService.deleteAllChildrenOlderThan(age);
    }

    public int count () {
        return familyService.count();
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
