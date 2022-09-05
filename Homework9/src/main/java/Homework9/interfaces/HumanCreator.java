package Homework9.interfaces;

import Homework9.Family;
import Homework9.Human;

public interface HumanCreator {

    Human bornChild(Family family, Human father);
}
