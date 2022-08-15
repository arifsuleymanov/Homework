package Homework7.interfaces;

import Homework7.Family;
import Homework7.Human;

public interface HumanCreator {

    Human bornChild(Family family, Human father);
}
