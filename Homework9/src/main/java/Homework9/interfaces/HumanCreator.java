package Homework9.interfaces;

import Homework8.Family;
import Homework8.Human;

public interface HumanCreator {

    Human bornChild(Family family, Human father);
}
