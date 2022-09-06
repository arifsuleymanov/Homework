package Homework11.interfaces;

import Homework11.Family;
import Homework11.Human;

import java.text.ParseException;

public interface HumanCreator {

    Human bornChild(Family family, Human father) throws ParseException;

}
