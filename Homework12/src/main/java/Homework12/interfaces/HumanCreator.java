package Homework12.interfaces;

import Homework12.Family;
import Homework12.Human;

import java.text.ParseException;

public interface HumanCreator {

    Human bornChild(Family family, Human father) throws ParseException;

}
