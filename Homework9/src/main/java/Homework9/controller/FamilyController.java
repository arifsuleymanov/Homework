package Homework9.controller;

import Homework9.Family;
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

    public List<Family> getFamiliesBiggerThan(int memberCount) {
        return familyService.getFamiliesBiggerThan(memberCount);
    }
}
