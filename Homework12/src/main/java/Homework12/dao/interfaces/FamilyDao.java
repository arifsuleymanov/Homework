package Homework12.dao.interfaces;

import Homework12.Family;

import java.util.List;

public interface FamilyDao {

    List<Family> getAllFamilies();

    Family getFamilyByIndex(int index);

    boolean deleteFamily(int index);

    void saveFamily(Family family);

}
