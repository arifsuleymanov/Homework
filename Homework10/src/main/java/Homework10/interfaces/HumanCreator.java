package Homework10.interfaces;

import Homework10.Family;
import Homework10.Human;

import java.text.ParseException;

public interface HumanCreator {

    Human bornChild(Family family, Human father) throws ParseException;

}
