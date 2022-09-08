package Homework13.service.impl;

import Homework13.Family;
import Homework13.file_storage.FamilyStorage;
import Homework13.logging.SpecialLogger;
import Homework13.service.FamilyDao;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionFamilyDao implements FamilyDao {

    private List<Family> families = new ArrayList<>();

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
            SpecialLogger.info("[DELETED] [FAMILY] with index = ["+index+"]!");

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
        SpecialLogger.info("[SAVED] [FAMILY] = ["+family.getFather().getSurname()+"]");
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

    @Override
    public void load() {
        families = FamilyStorage.load();
        SpecialLogger.info("Successfully loaded!");
    }

    @Override
    public void save() {
        FamilyStorage.save(families);
        SpecialLogger.info("Successfully saved!");
    }

}
