package Homework11.dao.entity;

import Homework11.Family;
import Homework11.dao.interfaces.FamilyDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionFamilyDao implements FamilyDao {

    private final List<Family> families = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return findFamilyByIndex(index).orElse(null);
    }

    @Override
    public boolean deleteFamily(int index) {
        if (findFamilyByIndex(index).isPresent()) {
            families.remove(families.get(index));
            return true;
        }
        return false;
    }


    @Override
    public void saveFamily(Family family) {
        if (findByReference(family).isPresent()) {
            families.set(families.indexOf(family), family);
        } else {
            families.add(family);
        }
    }

    private Optional<Family> findFamilyByIndex(int index) {
        return families.stream()
                .filter(family -> family.equals(families.get(index)))
                .findFirst();
    }

    private Optional<Family> findByReference(Family family) {
        return families.stream()
                .filter(f -> f.equals(family))
                .findFirst();
    }

}
