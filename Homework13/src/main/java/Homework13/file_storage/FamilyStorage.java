package Homework13.file_storage;

import Homework13.Family;
import Homework13.logging.SpecialLogger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FamilyStorage {
    private static final String path = "family.obj";

    public static List<Family> load() {
        Object object = null;

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {

            object = inputStream.readObject();
            return new ArrayList<>((List<Family>) object);

        } catch (IOException | ClassNotFoundException ex) {
            SpecialLogger.error("Error has occurred during loading the data!");
            throw new RuntimeException(ex);
        }

    }

    public static void save(List<Family> families) throws RuntimeException {

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(families);
        } catch (IOException ex) {
            SpecialLogger.error("Error has occurred during saving the data!");
        }

    }
}
