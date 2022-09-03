package Homework9.dao.entity;

import Homework9.Family;
import Homework9.dao.interfaces.FamilyDao;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {

    private final List<Family> families = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return false;
    }

    @Override
    public void saveFamily(Family family) {

    }
}
