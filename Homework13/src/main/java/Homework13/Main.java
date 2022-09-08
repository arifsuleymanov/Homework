package Homework13;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        FamilyApplication application = new FamilyApplication();
        while (application.start()) {
            if (!application.start()) break;
        }
    }
}
