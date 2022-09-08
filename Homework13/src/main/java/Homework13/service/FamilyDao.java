package Homework13.service;

import Homework13.Family;

import java.io.FileNotFoundException;
import java.util.List;

public interface FamilyDao {

    List<Family> getAllFamilies();

    Family getFamilyByIndex(int index);

    boolean deleteFamily(int index);

    void saveFamily(Family family);

    void load() throws FileNotFoundException;

    void save();

}
