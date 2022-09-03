package Homework9.service;

import Homework9.Family;
import Homework9.dao.interfaces.FamilyDao;

import java.util.List;
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
}
