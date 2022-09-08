package Homework13.interfaces;

import Homework13.Family;
import Homework13.Human;

import java.text.ParseException;

public interface HumanCreator {

    Human bornChild(Family family, Human father) throws ParseException;

}
